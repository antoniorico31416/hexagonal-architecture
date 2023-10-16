package com.course.hexagonal.architecture.domain.book;

import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    List<BookItem> books;

}
