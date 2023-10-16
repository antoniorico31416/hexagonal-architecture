package com.course.hexagonal.architecture.domain.book;

import com.course.hexagonal.architecture.domain.admin.Author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Book {
    private String name;
    private String author;
    private GenreBook genre;
    private long isbn;
    private BookState state;
}