package com.example.springapi.api.model;

public class Book {

    private int id;
    private String author;
    private String title;
    private String synopsis;
    private String releaseDate;

    public Book(int id, String author, String title, String synopsis, String releaseDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
