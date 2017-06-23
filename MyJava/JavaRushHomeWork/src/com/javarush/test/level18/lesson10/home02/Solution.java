package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name = "";
        FileInputStream fis = new FileInputStream(name);
        int symbols = fis.available();
        int spaces = 0;

        while (fis.available() > 0){
            int i =  fis.read();
            if (i == 20) spaces++;
        }
        String formatted = new DecimalFormat("#0.00").format((double) symbols / spaces * 10);
        System.out.println(formatted);
        fis.close();
    }
}
