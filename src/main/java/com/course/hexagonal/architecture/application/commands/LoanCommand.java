package com.course.hexagonal.architecture.application.commands;

import com.course.hexagonal.architecture.domain.book.BookItem;
import com.course.hexagonal.architecture.domain.admin.Client;
import lombok.Data;

import java.util.Set;

@Data
public class LoanCommand {
    private Client client;
    private Set<BookItem> books;
}
