package com.snap.anonyme;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Article implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private Fichier fichier;
    private boolean isVisible;
    private int nbReports;

    public Article() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.fichier = new Fichier();
        this.isVisible = true;
        this.nbReports = 0;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }
    public Article(String fichier) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.fichier = new Fichier(fichier);
        this.isVisible = true;
        this.nbReports = 0;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", fichier=" + fichier +
                ", isVisible=" + isVisible +
                ", nbReports=" + nbReports +
                '}';
    }
}
