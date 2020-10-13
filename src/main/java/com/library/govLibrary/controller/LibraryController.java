package com.library.govLibrary.controller;

import com.library.govLibrary.model.Library;
import com.library.govLibrary.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/library/{id}")
    public Library getById(@PathVariable long id){
        return libraryService.getById(id);
    }

    @GetMapping("/librarys")
    public List<Library> getLibrarys(@RequestParam(required = false) int page) { return libraryService.getLibrarys(page); }
}
