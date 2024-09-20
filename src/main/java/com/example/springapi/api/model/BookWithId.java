package com.example.springapi.api.model;

/**
 * BookWithId class that allows for creation of Book object with unique id
 */
public class BookWithId extends Book{

    private Integer id;
    private static int count = 0;

    public BookWithId(String title, String author, String synopsis, String releaseDate) {
        super(author, title, synopsis, releaseDate);
        this.id = count;
        incrementCount();
    }

    private void incrementCount() {
        count++;
    }

    public Integer getId() {
        return this.id;
    }

}
