package com.library.govLibrary.repository;

import com.library.govLibrary.model.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select distinct a from Author a left join fetch a.book where a.surname = :surname")
    List<Author> findAllAuthorsBySurname(String surname);

    @Query("select a from Author a")
    List<Author> findAllAuthors(Pageable page);

    @Query("select distinct a from Author a left join fetch a.book where a.id = :id")
    Optional<Author> findByIdWithBooks(long id);

    @Query("select distinct a from Author a where a.id = :id")
    Optional<Author> findById(long id);
}
