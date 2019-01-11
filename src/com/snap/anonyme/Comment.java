package com.snap.anonyme;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Comment implements Serializable{
    private static int nb=0;
    private static ArrayList nbList = new ArrayList();

    private int id;
    private User user;
    private Article article;
    private Comment comment;
    private String content;
    private Date date;

    public Comment() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.user = new User();
        this.article = new Article();
        this.comment = new Comment();
        this.content = null;
        this.date = new Date();

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
    }
    public Comment(User user, Article article, Comment comment, String content) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.user = user;
        this.article = article;
        this.comment = comment;
        this.content = content;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", article=" + article +
                ", comment=" + comment +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
