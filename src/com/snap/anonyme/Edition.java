package com.snap.anonyme;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Edition implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private User user;
    private Article article;
    private Date date;

    public Edition() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.user = new User();
        this.article = new Article();
        this.date = new Date();

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }

    public Edition(User user, Article article) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.user = user;
        this.article = article;
        this.date = new Date();

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }
    public int getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", user=" + user +
                ", article=" + article +
                ", date=" + date +
                '}';
    }
}
