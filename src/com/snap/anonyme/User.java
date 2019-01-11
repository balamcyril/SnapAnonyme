package com.snap.anonyme;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

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
        this.nbList.add(this.id);
        this.nb++;
    }
    public User() {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.login = null;
        this.password = null;

        while (this.nbList.contains(this.id)){
            this.id = random.nextInt(1000);
        }
        this.nbList.add(this.id);
        this.nb++;
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
