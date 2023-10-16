package com.course.hexagonal.architecture.adapters.in.api.rest.controller.impl;

import com.course.hexagonal.architecture.adapters.in.api.rest.controller.BookController;
import com.course.hexagonal.architecture.adapters.in.api.rest.mappers.BookDTOMapper;
import com.course.hexagonal.architecture.application.service.book.CatalogService;
import com.course.hexagonal.architecture.domain.book.BookItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/book")
public class BookControllerImpl implements BookController {

    private final CatalogService catalogService;

    @GetMapping("/findAll")
    @Override
    public List<BookItem> findAll() {
        return catalogService.getAll();
    }
}
