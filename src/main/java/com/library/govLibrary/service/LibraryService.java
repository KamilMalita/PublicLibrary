package com.library.govLibrary.service;

import com.library.govLibrary.model.Library;
import com.library.govLibrary.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    public static final int SIZE = 20;
    private final LibraryRepository libraryRepository;

    public Library getById(long id){
        return libraryRepository.findLibraryById(id).orElseThrow();
    }

    public List<Library> getLibrarys(int page){
        return libraryRepository.findAllLibrarys(PageRequest.of(page, SIZE));
    }
}
