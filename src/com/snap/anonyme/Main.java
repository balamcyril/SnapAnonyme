package com.snap.anonyme;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void init()
    {
        File file = new File("nbArticle.txt");
        try {
            FileReader fr;
            fr = new FileReader(file);
            fr.close();
        }catch (IOException e1)
        {
            try{
                FileWriter fw;
                fw = new FileWriter(file);
                String str = "0";
                fw.write(str);
                fw.close();

            }catch (IOException e2)
            {
                System.out.println("erreur d'initialisation");
            }
        }
        File file1 = new File("nbUser.txt");
        try {
            FileReader fr;
            fr = new FileReader(file1);
            fr.close();
        }catch (IOException e1)
        {
            try{
                FileWriter fw;
                fw = new FileWriter(file1);
                String str = "0";
                fw.write(str);
                fw.close();
            }catch (IOException e2)
            {
                System.out.println("erreur d'initialisation");
            }
        }

        File file2 = new File("listUser.txt");
        try {
            FileReader fr;
            fr = new FileReader(file2);
            fr.close();
        }catch (IOException e1)
        {
            try{
                FileWriter fw;
                fw = new FileWriter(file2);
                String str = "";
                fw.write(str);
                fw.close();
            }catch (IOException e2)
            {
                System.out.println("erreur d'initialisation");
            }
        }

        File file3 = new File("listArticle.txt");
        try {
            FileReader fr;
            fr = new FileReader(file3);
            fr.close();
        }catch (IOException e1)
        {
            try{
                FileWriter fw;
                fw = new FileWriter(file3);
                String str = "";
                fw.write(str);
                fw.close();
            }catch (IOException e2)
            {
                System.out.println("erreur d'initialisation");
            }
        }

    }

    public static void ajouterArticle(User user)
    {
        String content, image;
        Scanner affiche = new Scanner(System.in);
        System.out.println("Vous allez ajouter un article:");
        System.out.println("Veuillez entrer le contenu de l'article\n");
        content = affiche.nextLine();
        System.out.println("Veuillez entrer l'image de l'article\n");
        image = affiche.nextLine();

        Article article = new Article(content, image, user);
        System.out.println("Votre article à bien été enregistré\n\n\n\n");
        listArticle(user.getId());

    }
    public static void consulterArticle(User user){
        int entrer;
        Scanner affiche = new Scanner(System.in);

        System.out.println("Vous allez consulter un article");
        System.out.println("Veuillez entrer le numero de l'article que vous souhaitez consulter\n\n");
        entrer = affiche.nextInt();

        System.out.println("Détails de votre article");

        System.out.println(getArticle(entrer).affiche());

        System.out.println("\n\n");
        listArticle(user.getId());




    }
    public static void listArticle(int rep)
    {
        User user = getUtilisateur(rep);
        boolean test = true;
        String entrer;
        Scanner affiche = new Scanner(System.in);

        try {
            File file = new File("nbArticle.txt");
            FileReader fr;

            fr = new FileReader(file);
            String str ="";
            int i = 0;
            while ((i = fr.read()) != -1)
                str += (char) i;
            int nbArticle= Integer.valueOf(str).intValue();
            fr.close();
            ArrayList listArticle = new ArrayList();
            ObjectInputStream ois;
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listArticle.txt"))));
            for (i=0; i<nbArticle; i++)
                listArticle.add((Article)ois.readObject());

            ois.close();
            Article article;
            if(nbArticle == 0)
            {
                System.out.println("Vous n'avez aucun article");

            }
            else{
                System.out.println("Liste de mes articles: \n");

                for (i=0; i<nbArticle; i++) {
                    article = (Article)listArticle.get(i);
                    if (article.getUser().getId() == user.getId())
                        System.out.println(article);

                }
            }


            do
            {
                System.out.println("1: Consulter un article");
                System.out.println("2: Ajouter un article");
                System.out.println("0: Pour quitter\n");
                System.out.println("Faites votre choix:");
                entrer = affiche.nextLine();
                try
                {
                    rep= Integer.valueOf(entrer).intValue();
                }
                catch(NumberFormatException e)
                {
                    rep= -1;
                }

                if(rep >= 0 && rep <=6)
                {
                    rep= Integer.valueOf(entrer).intValue();
                    test=false;
                    if(rep == 0)
                    {
                        System.out.println("Merci d'avoir utiliser notre application");
                        System.exit(1);
                    }
                }
                else
                {
                    System.out.println("Nous n'avons pas compris votre choix, veuillez reessayer!\n");
                    test=true;


                }
            }while(test);
            switch (rep){
                case 1:
                    consulterArticle(user);
                    break;
                case 2:
                    ajouterArticle(user);
                default:
                    System.out.println("Merci d'avoir utiliser notre application");
                    System.exit(1);
            }


        }catch (FileNotFoundException e)
        {
            System.out.println("Aucun utilisateur, inscrivez-vous!\n\n");
            inscription();
        }
        catch (IOException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }

    }
    public static int testUtilisateur(String login, String password){

        try {
            File file = new File("nbUser.txt");
            FileReader fr;
            System.out.println("nbuser\n");
            fr = new FileReader(file);
            String str ="";
            int i = 0;
            while ((i = fr.read()) != -1)
                str += (char) i;
            int nbUser= Integer.valueOf(str).intValue();
            fr.close();
            ArrayList listUser = new ArrayList();
            ObjectInputStream ois;
            System.out.println("list user\n");
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listUser.txt"))));
            System.out.println(nbUser);
            for (i=0; i<nbUser; i++)
                listUser.add((User)ois.readObject());

            ois.close();
            System.out.println("fin read\n");
            User user;
            for (i=0; i<nbUser; i++) {
                user = (User)listUser.get(i);
                if (user.getLogin() == login && user.getPassword() == password)
                    return user.getId();

            }
            return 0;

        }catch (FileNotFoundException e)
        {
            System.out.println("Aucun utilisateur, inscrivez-vous!\n\n");
            return 0;
        }
        catch (IOException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            return 0;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            return 0;
        }
    }
    public static User getUtilisateur(int id){
        User ret = new User();

        try {
            File file = new File("nbUser.txt");
            FileReader fr;

            fr = new FileReader(file);
            String str ="";
            int i = 0;
            while ((i = fr.read()) != -1)
                str += (char) i;
            int nbUser= Integer.valueOf(str).intValue();
            fr.close();
            ArrayList listUser = new ArrayList();
            ObjectInputStream ois;
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listUser.txt"))));
            for (i=0; i<nbUser; i++)
                listUser.add((User)ois.readObject());

            ois.close();
            User user;
            for (i=0; i<nbUser; i++) {
                user = (User)listUser.get(i);
                if (user.getId() == id)
                    ret= user;

            }

        }catch (FileNotFoundException e)
        {
            System.out.println("Aucun utilisateur, inscrivez-vous!\n\n");
            inscription();
        }
        catch (IOException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }
    return ret;
    }
    public static Article getArticle(int id){
        Article ret = new Article();
        try {
            File file = new File("nbArticle.txt");
            FileReader fr;

            fr = new FileReader(file);
            String str ="";
            int i = 0;
            while ((i = fr.read()) != -1)
                str += (char) i;
            int nbArticle= Integer.valueOf(str).intValue();
            fr.close();
            ArrayList listArticle = new ArrayList();
            ObjectInputStream ois;
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("listArticle.txt"))));
            for (i=0; i<nbArticle; i++)
                listArticle.add((Article)ois.readObject());


            ois.close();
            Article article;
            for (i=0; i<nbArticle; i++) {
                article = (Article)listArticle.get(i);
                if (article.getId() == id)
                    ret= article;

            }


        }catch (FileNotFoundException e)
        {
            System.out.println("Aucun utilisateur, inscrivez-vous!\n\n");
            inscription();
        }
        catch (IOException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("erreur de lecture des utilisateur, veuillez créer un compte!\n\n");
            inscription();
        }
    return ret;
    }


    public static void connexion(){
        Scanner affiche = new Scanner(System.in);
        String login, password;
        int rep;
        String entrer;
        boolean test;


            System.out.println("Entrez votre login:\n");
            login = affiche.nextLine();

            System.out.println("\n");

            System.out.println("Entrez votre password:");
            password = affiche.nextLine();

             System.out.println("entrer test utilisateur\n");
            rep = testUtilisateur(login,password);
            if (rep>0)
            {
                System.out.println("entrer list artice\n");
                listArticle(rep);
            }
            else
            {


                System.out.println("Login ou mot de passe incorrect\n");
                do
                {
                    System.out.println("1: Se connecter");
                    System.out.println("2: S'inscrire");
                    System.out.println("0: Pour quitter\n");
                    System.out.println("Faites votre choix:");
                    entrer = affiche.nextLine();
                    try
                    {
                        rep= Integer.valueOf(entrer).intValue();
                    }
                    catch(NumberFormatException e)
                    {
                        rep= -1;
                    }

                    if(rep >= 0 && rep <=6)
                    {
                        rep= Integer.valueOf(entrer).intValue();
                        test=false;
                        if(rep == 0)
                        {
                            System.out.println("Merci d'avoir utiliser notre application");
                            System.exit(1);
                        }
                    }
                    else
                    {
                        System.out.println("Nous n'avons pas compris votre choix, veuillez reessayer!\n");
                        test=true;


                    }
                }while(test);
                switch (rep){
                    case 1:
                        connexion();
                        break;
                    case 2:
                        inscription();
                    default:
                        System.out.println("Merci d'avoir utiliser notre application");
                        System.exit(1);
                }
            }




    }
    public static void inscription(){
        Scanner affiche = new Scanner(System.in);
        String login, password;
        int rep;
        String entrer;
        boolean test;


        System.out.println("Entrez votre login:\n");
        login = affiche.nextLine();

        System.out.println("\n");

        System.out.println("Entrez votre password:");
        password = affiche.nextLine();

        User user = new User(login,password);
        System.out.println("Votre compte a bien été crée\n");
        System.out.println("\n\n");
        connexion();


    }

    public static void main(String[] args) {
        Scanner affiche = new Scanner(System.in);
        boolean test = true;
        String entrer;
        int rep;
        init();
        System.out.println("Bienvenue sur SnapAnonyme\n");
        do
        {
            System.out.println("1: Se connecter");
            System.out.println("2: S'inscrire");
            System.out.println("0: Pour quitter\n");
            System.out.println("Faites votre choix:");
            entrer = affiche.nextLine();
            try
            {
                rep= Integer.valueOf(entrer).intValue();
            }
            catch(NumberFormatException e)
            {
                rep= -1;
            }

            if(rep >= 0 && rep <=6)
            {
                rep= Integer.valueOf(entrer).intValue();
                test=false;
                if(rep == 0)
                {
                    System.out.println("Merci d'avoir utiliser notre application");
                    System.exit(1);
                }
            }
            else
            {
                System.out.println("Nous n'avons pas compris votre choix, veuillez reessayer!\n");
                test=true;


            }
        }while(test);
        switch (rep){
            case 1:
                connexion();
                break;
            case 2:
                inscription();
            default:
                System.out.println("Merci d'avoir utiliser notre application");
                System.exit(1);
        }

    }
}
