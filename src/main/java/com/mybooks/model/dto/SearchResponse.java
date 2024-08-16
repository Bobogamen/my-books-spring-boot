package com.mybooks.model.dto;

import com.mybooks.model.entity.Book;

import java.util.List;

public class SearchResponse {

    private List<ListAuthorsDTO> authors;
    private List<Book> books;

    public SearchResponse(List<ListAuthorsDTO> authors, List<Book> books) {
        this.authors = authors;
        this.books = books;
    }

    public List<ListAuthorsDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<ListAuthorsDTO> authors) {
        this.authors = authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
