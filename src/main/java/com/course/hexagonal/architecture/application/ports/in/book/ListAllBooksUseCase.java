package com.course.hexagonal.architecture.application.ports.in.book;

import com.course.hexagonal.architecture.domain.book.BookItem;

import java.util.List;

public interface ListAllBooksUseCase {
    List<BookItem> getAll();
}
