package com.snap.anonyme;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Reaction implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private Article article;
    private Comment comment;
    private User user;
    private Date date;
    private String Type;

    public Reaction() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.article = new Article();
        this.comment = new Comment();
        this.user = new User();
        this.date = new Date();
        this.Type = null;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;

    }
    public Reaction(Article article, Comment comment, User user,String type) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.article = article;
        this.comment = comment;
        this.user = user;
        this.date = new Date();
        this.Type = type;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;

    }

    public int getId() {
        return id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "id=" + id +
                ", article=" + article +
                ", comment=" + comment +
                ", user=" + user +
                ", date=" + date +
                ", Type='" + Type + '\'' +
                '}';
    }
}
