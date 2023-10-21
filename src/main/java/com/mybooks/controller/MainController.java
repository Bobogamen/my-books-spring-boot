package com.mybooks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mybooks.model.entity.Book;
import com.mybooks.model.dto.AuthorDTO;
import com.mybooks.service.AuthorService;
import com.mybooks.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://mybooks.up.railway.app")
public class MainController {

    private final BookService bookService;
    private final AuthorService authorService;

    public MainController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable long id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/add-book")
    public boolean addBook(@RequestParam String title, @RequestParam long authorId) {
        return this.bookService.addBook(title, authorId);
    }

    @PostMapping("/edit-book")
    public boolean editBook(@RequestBody String book) throws JsonProcessingException {
        return this.bookService.editBook(book);
    }

    @PostMapping("/delete-book/{id}")
    public boolean deleteBook(@PathVariable long id) {
        return this.bookService.deleteBook(id);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return this.authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public AuthorDTO getAuthor(@PathVariable long id) {
        return this.authorService.getAuthor(id);
    }

    @PostMapping("/add-author")
    public String addAuthor(@RequestBody String name) {
        return this.authorService.addAuthor(name);
    }

    @PostMapping("/edit-author")
    public String editAuthor(@RequestParam long id, @RequestParam String name) {
        return this.authorService.editAuthorName(id, name);
    }

    @PostMapping("/delete-author/{id}")
    public boolean deleteAuthorAndHisBooks(@PathVariable long id) {
        return this.authorService.deleteAuthorByIdAndHisBooks(id);
    }

    @PostMapping("/search")
    public List<Book> search(@RequestParam String word) {
        return this.bookService.searchBook(word);
    }

}
