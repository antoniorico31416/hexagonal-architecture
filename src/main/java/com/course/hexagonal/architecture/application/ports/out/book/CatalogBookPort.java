package com.course.hexagonal.architecture.application.ports.out.book;

import com.course.hexagonal.architecture.domain.book.BookItem;

import java.util.List;

public interface CatalogBookPort {

    BookItem findBook(long isbn);

    List<BookItem> retrieveCatalog();


}
