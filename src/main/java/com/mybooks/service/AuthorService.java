package com.mybooks.service;

import com.mybooks.model.dto.ListAuthorsDTO;
import com.mybooks.model.entity.Author;
import com.mybooks.model.dto.AuthorDTO;
import com.mybooks.repository.AuthorRepository;
import com.mybooks.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<ListAuthorsDTO> getAllAuthors() {
        return this.authorRepository.findAll().stream().map(a -> {
                    ListAuthorsDTO author = new ListAuthorsDTO();
                    author.setId(a.getId());
                    author.setName(a.getName());
                    author.setBooks(this.bookRepository.getBooksByAuthorId(a.getId()).size());

                    return author;

                }).sorted(Comparator.comparing(ListAuthorsDTO::getName)).
                collect(Collectors.toList());
    }

    public AuthorDTO getAuthor(long id) {
        Author author = this.authorRepository.getAuthorById(id);

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBooks(this.bookRepository.getBooksByAuthorId(id));

        return authorDTO;
    }

    public boolean addAuthor(String name) {
        name = name.replaceAll("\\+", " ");

        if (this.authorRepository.findAuthorByNameIgnoreCase(name).isPresent()) {
            return false;
        }

        Author author = new Author();
        author.setName(name);

        this.authorRepository.save(author);

        return true;
    }


    public boolean deleteAuthorByIdAndHisBooks(long authorId) {
        bookRepository.deleteAll(this.bookRepository.getBooksByAuthorId(authorId));
        this.authorRepository.deleteById(authorId);

        return true;
    }

    public String editAuthorName(long id, String name) {
        Author author = this.authorRepository.getAuthorById(id);
        author.setName(name);
        return this.authorRepository.save(author).getName();
    }

    public List<ListAuthorsDTO> findAuthorByName(String word) {
        return this.authorRepository.findAuthorByName(word);
    }
}
