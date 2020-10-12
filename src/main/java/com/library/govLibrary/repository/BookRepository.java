package com.library.govLibrary.repository;

import com.library.govLibrary.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b")
    List<Book> findAllBooks(Pageable page);

    @Query("select distinct b from Book b where b.title like %:title%")
    List<Book> findAllContainTitle(String title);

    @Query("select distinct b from Book b where b.authorId = :id")
    List<Book> findAllBooksForAuthor(long id);

    @Query("select b from Book b where b.id = :id")
    Optional<Book> findByAuthorId(long id);

    List<Book> findAllByAuthorIdIn(List<Long> ids);
}
