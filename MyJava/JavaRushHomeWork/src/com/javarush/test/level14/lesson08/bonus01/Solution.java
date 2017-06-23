package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception

        try {
            float i = 1 / 0;
        }
        catch (Exception e) {
            exceptions.add(e);
        }


        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        }
        catch (ClassCastException e) {
            exceptions.add(e);

        }

        try {
            String s = null;
            s.length();
        }
        catch (NullPointerException e) {
            exceptions.add(e);
        }


        try {
            Thread.currentThread().interrupt();
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
            exceptions.add(e);
        }

        try {
            Solution test = new Solution();
            test.clone();
        }
        catch (CloneNotSupportedException e) {
            exceptions.add(e);
        }


        try {
            String s = "sdf";
            int i = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            exceptions.add(e);
        }



        try {
            int[] mas = new int[-1];
        }
        catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }



        try {
            String s = "..";
            s.charAt(5);
        }
        catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }


        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);

        }
        catch (ArrayStoreException e) {
            exceptions.add(e);
        }


        try {
            int[] mas = new int[0];
            int i = mas[1];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }


    }
}