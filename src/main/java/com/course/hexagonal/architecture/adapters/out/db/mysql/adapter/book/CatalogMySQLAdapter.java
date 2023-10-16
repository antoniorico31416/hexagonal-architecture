package com.course.hexagonal.architecture.adapters.out.db.mysql.adapter.book;

import com.course.hexagonal.architecture.adapters.out.db.mysql.entity.BookItemEntity;
import com.course.hexagonal.architecture.adapters.out.db.mysql.mappers.BookIMapper;
import com.course.hexagonal.architecture.adapters.out.db.mysql.repository.book.BookRepository;
import com.course.hexagonal.architecture.application.ports.out.book.CatalogBookPort;
import com.course.hexagonal.architecture.domain.book.BookItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CatalogMySQLAdapter implements CatalogBookPort {

    private final BookRepository bookRepository;

    private final BookIMapper bookItemMapper;

    @Override
    public BookItem findBook(long isbn) {
        return null;
    }

    @Override
    public List<BookItem> retrieveCatalog() {

        try{
            List<BookItemEntity> bookItemEntities = bookRepository.findAll();

            if (!bookItemEntities.isEmpty()) {
                return bookItemMapper.toDomainModel(bookItemEntities);
            }
            return new ArrayList<>();

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
