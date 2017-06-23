package com.javarush.test.level19.lesson05.task01;
/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        FileWriter file2 = new FileWriter(reader.readLine());
        reader.close();
        int count = 0;
        while (file1.ready()) {
            count++;
            int data = file1.read();
            if (count % 2 != 0) {
            }
            file2.close();
            file1.close();
        }
    }
}