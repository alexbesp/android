package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = reader.readLine();
            if (s.equals("exit") || s.equals("")) break;
            ReadThread thr = new ReadThread(s);
            thr.start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);

                int[] mas = new int[256];
                while (fis.available() > 0) {
                    mas[fis.read()]++;
                }
                int max = mas[0];
                for (int i = 1; i < mas.length; i++) {
                    if (mas[i] > max) max = mas[i];
                }
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < mas.length; i++) {
                    if (mas[i] == max) set.add(i);
                }
                for (int value : set){
                    resultMap.put(fileName, value);
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
