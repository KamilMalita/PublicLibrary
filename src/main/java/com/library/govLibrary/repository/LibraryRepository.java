package com.library.govLibrary.repository;

import com.library.govLibrary.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
