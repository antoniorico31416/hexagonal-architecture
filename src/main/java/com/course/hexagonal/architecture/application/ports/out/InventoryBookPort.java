package com.course.hexagonal.architecture.application.ports.out;

import com.course.hexagonal.architecture.domain.Books.BookItem;

public interface InventoryBookPort {

    void addBook(BookItem book);

    void updateInventoryBook(long isbn, int numCopies);
}
