package com.snap.anonyme;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class User implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private String login;
    private String password;

    public User(String login, String password) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.login = login;
        this.password = password;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }

        try {
            File file = new File("nbUser.txt");
            FileReader fr;

            fr = new FileReader(file);
            String str = "";
            int i = 0;
            while ((i = fr.read()) != -1)
                str += (char) i;
            this.nb = Integer.valueOf(str).intValue();
            fr.close();
            System.out.println("nb utilisateur ="+ this.nb);

            ObjectInputStream ois;
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listUser.txt"))));

            System.out.println("nb fin ="+ this.nb);
            for (i=0; i<this.nb; i++)
                this.nbList.add((User)ois.readObject());

            this.nbList.add(this);
            FileWriter fw;
            fw = new FileWriter(file);
            fw.write(this.nb++);
            fw.close();

            ObjectOutputStream oos;
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("listUser.txt"))));
            for (i=0; i<this.nb; i++)
                oos.writeObject(this.nbList.get(i));

            ois.close();
            oos.close();
        }catch (FileNotFoundException e)
        {System.out.println("Aucun fichier nbuser a lire");}
        catch (IOException e)
        {System.out.println("Le fichier nbuser ne peu pas être lu");}
        catch (ClassNotFoundException e)
        {System.out.println("La classe User n'existe pas");}
    }
    public User() {
        this.login = null;
        this.password = null;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
