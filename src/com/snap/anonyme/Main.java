package com.snap.anonyme;

import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int i = random.nextInt(1000);
        System.out.println(i);

        i = random.nextInt(1000);
        System.out.println(i);

    }
}
