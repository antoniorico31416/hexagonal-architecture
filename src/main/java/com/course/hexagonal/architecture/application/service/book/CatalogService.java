package com.course.hexagonal.architecture.application.service.book;

import com.course.hexagonal.architecture.application.ports.in.book.AddBookUseCase;
import com.course.hexagonal.architecture.application.ports.in.book.ListAllBooksUseCase;
import com.course.hexagonal.architecture.application.ports.out.book.CatalogBookPort;
import com.course.hexagonal.architecture.domain.book.BookItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService implements AddBookUseCase, ListAllBooksUseCase {

    private final CatalogBookPort catalogBookPort;

    @Override
    public void addBook() {

    }

    @Override
    public List<BookItem> getAll() {
        return catalogBookPort.retrieveCatalog();
    }
}
