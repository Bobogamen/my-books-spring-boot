package com.mybooks.repository;

import com.mybooks.model.dto.ListAuthorsDTO;
import com.mybooks.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorById(long id);

    @Query("SELECT new com.mybooks.model.dto.ListAuthorsDTO(a.id, a.name, COUNT(b.id)) " +
            "FROM Author a " +
            "JOIN Book b ON b.author.id = a.id " +
            "WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :word, '%'))" +
            "GROUP BY a.id, a.name")
    List<ListAuthorsDTO> findAuthorByName(String word);

    Optional<Author> findAuthorByNameIgnoreCase(String name);
}
