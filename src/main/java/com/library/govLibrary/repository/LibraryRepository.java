package com.library.govLibrary.repository;

import com.library.govLibrary.model.Library;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    @Query("select l from Library l where l.id = :id")
    Optional<Library> findLibraryById(long id);

    @Query("select  l from Library l")
    List<Library> findAllLibrarys(Pageable page);
}
