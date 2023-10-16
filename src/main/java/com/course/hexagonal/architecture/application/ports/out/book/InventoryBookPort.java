package com.course.hexagonal.architecture.application.ports.out.book;

import com.course.hexagonal.architecture.domain.book.BookItem;

public interface InventoryBookPort {

    void addBook(BookItem book);

    void updateInventoryBook(long isbn, int numCopies);
}
