package com.snap.anonyme;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class Article implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private String content;
    private User user;
    private Fichier fichier;
    private boolean isVisible;
    private int nbReports;

    public Article() {
        this.id = 0;
        this.fichier = new Fichier();
        this.user = new User();
        this.content = null;
        this.isVisible = true;
        this.nbReports = 0;
    }


    public Article(String content, String fichier, User user) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.fichier = new Fichier(fichier);
        this.user = user;
        this.content = content;

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
            ObjectInputStream ois;
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listArticle.txt"))));
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
                                    new File("listArticle.txt"))));
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

    public int getId() {
        return id;
    }
    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getNbReports() {
        return nbReports;
    }

    public void setNbReports(int nbReports) {
        this.nbReports = nbReports;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ""+ id +
                ": '" + content +
                ", photo:" + fichier +
                "";
    }

    public String affiche() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", fichier=" + fichier +
                ", isVisible=" + isVisible +
                ", nbReports=" + nbReports +
                '}';
    }
}
