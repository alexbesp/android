package com.javarush.test.level06.lesson11.home03;

/* Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.
*/

import java.util.Date;

public class Solution
{

    public static int A = 5;
    public int B = 2;
    public  int C = A*B;

    public static void main(String[] args)
    {
        A = 15;
    Date date = new Date();
        System.out.println(date.getMonth());
    }
}

