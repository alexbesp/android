package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fos;

    public AdapterFileOutputStream(FileOutputStream fos) throws FileNotFoundException {
        this.fos = fos;
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    public void writeString(String s) throws IOException {
        fos.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }


}

