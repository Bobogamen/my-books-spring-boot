package com.mybooks.model.dto;

public class ListAuthorsDTO {

    private long id;
    private String name;
    private long books;

    public ListAuthorsDTO() {
    }

    public ListAuthorsDTO(long id, String name, long books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBooks() {
        return books;
    }

    public void setBooks(long books) {
        this.books = books;
    }
}
