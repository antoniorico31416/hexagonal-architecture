package com.course.hexagonal.architecture.domain.Books;

import com.course.hexagonal.architecture.domain.admin.Author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String name;
    private Author author;
    private GenreBook genre;
    private long isbn;
    private BookState state;
}