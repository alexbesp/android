package com.javarush.test.level15.lesson12.home04;

/**
 * Created by alexander.bespalov on 11.11.2016.
 */
public class Earth implements Planet {
    private static Earth instance = null;

    private Earth() {}

    public static Earth getInstance() {
        if (instance == null) instance = new Earth();
        return instance;
    }
}
