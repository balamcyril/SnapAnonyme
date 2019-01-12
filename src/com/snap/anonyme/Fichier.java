package com.snap.anonyme;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Fichier implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private String url;
    private float size;
    private String mimeType;

    public Fichier() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.url = null;
        this.size = 1.0f;
        this.mimeType = "jpg";

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }
    public Fichier(String url) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.url = url;
        this.size = 1.0f;
        this.mimeType = "jpg";

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getSize() {
        return size;
    }

    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String toString() {
        return "" + url +
                "." + mimeType +
                "";
    }
}
