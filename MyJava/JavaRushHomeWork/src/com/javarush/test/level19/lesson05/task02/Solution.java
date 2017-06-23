package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileReader fileReader = new FileReader(name);
        String s = "";
        while (fileReader.ready()) {
            s += fileReader.read();
        }
        int counter = 0;
        String[] splitResults = s.split("\\W");
        for (int i = 0; i < splitResults.length; i++) {
            if (splitResults[i].equals("world"));
        counter++;
        }
        System.out.println(counter);
        fileReader.close();
        reader.close();

    }
}
