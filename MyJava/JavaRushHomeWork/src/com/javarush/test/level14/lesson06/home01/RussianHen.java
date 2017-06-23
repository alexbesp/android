package com.javarush.test.level14.lesson06.home01;

/**
 * Created by alexander.bespalov on 04.10.2016.
 */
public class RussianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 5;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
