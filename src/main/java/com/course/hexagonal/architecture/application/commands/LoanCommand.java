package com.course.hexagonal.architecture.application.commands;

import com.course.hexagonal.architecture.domain.Books.BookItem;
import com.course.hexagonal.architecture.domain.admin.Client;
import lombok.Data;

import java.util.List;

@Data
public class LoanCommand {
    private Client client;
    private List<BookItem> books;
}
