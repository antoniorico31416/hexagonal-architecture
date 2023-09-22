package com.course.hexagonal.architecture.application.ports.out;

import com.course.hexagonal.architecture.domain.Books.BookItem;
import com.course.hexagonal.architecture.domain.Books.Inventory;

import java.util.List;

public interface CatalogBookPort {

    BookItem findBook(long isbn);

    List<BookItem> retrieveCatalog();


}
