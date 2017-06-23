package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(name)) System.out.println(name + " is " + (i + 1)  + " month");
        }

        //напишите тут ваш код
    }

}
