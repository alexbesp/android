package com.javarush.test.level15.lesson02.task04;

/**
 * Created by alexander.bespalov on 03.11.2016.
 */
public class MarkTwainBook extends Solution.Book {

    private String bookName;

    public MarkTwainBook(String bookName) {
        super("Mark Twain");
        this.bookName = bookName;
    }

    @Override
    public MarkTwainBook getBook() {
        return this;
    }

    @Override
    public String getName() {
        return bookName;
    }
}
