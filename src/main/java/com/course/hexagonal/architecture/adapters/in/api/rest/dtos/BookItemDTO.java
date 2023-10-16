package com.course.hexagonal.architecture.adapters.in.api.rest.dtos;

import com.course.hexagonal.architecture.domain.admin.Author;
import com.course.hexagonal.architecture.domain.book.BookState;
import com.course.hexagonal.architecture.domain.book.GenreBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookItemDTO {
    private long isbn;

    private String name;
    private String author;
    private GenreBook genre;
    private BookState state;
    private int availableCopies;
}
