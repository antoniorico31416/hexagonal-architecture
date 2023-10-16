package com.course.hexagonal.architecture.adapters.in.api.rest.controller;

import com.course.hexagonal.architecture.adapters.in.api.rest.dtos.BookItemDTO;

import com.course.hexagonal.architecture.domain.book.BookItem;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.List;

public interface BookController {

    @GetMapping("/findAll")
    List<BookItem> findAll();
}
