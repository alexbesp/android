package com.javarush.test.level15.lesson02.task04;

/**
 * Created by alexander.bespalov on 03.11.2016.
 */
public class AgathaChristieBook extends Solution.Book {

    private String bookName;

    public AgathaChristieBook(String bookName) {
        super("Agatha Christie");
        this.bookName = bookName;
    }

    @Override
    public AgathaChristieBook getBook() {
        return this;
    }

    @Override
    public String getName() {
        return bookName;
    }
}
