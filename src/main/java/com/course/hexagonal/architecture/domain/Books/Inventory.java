package com.course.hexagonal.architecture.domain.Books;

import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    List<BookItem> books;

}
