package com.library.govLibrary.repository;

import com.library.govLibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select distinct a from Author a left join fetch a.book where a.surname = :surname")
    List<Author> findAllBySurname(String surname);

    @Query("select distinct a from Author a left join fetch a.book")
    List<Author> findAllAuhors();
}
