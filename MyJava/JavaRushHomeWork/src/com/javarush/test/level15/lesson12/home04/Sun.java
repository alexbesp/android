package com.javarush.test.level15.lesson12.home04;

/**
 * Created by alexander.bespalov on 11.11.2016.
 */
public class Sun implements Planet {
   private static Sun instance = null;

    private Sun(){}

    public static synchronized Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return  instance;
    }
}
