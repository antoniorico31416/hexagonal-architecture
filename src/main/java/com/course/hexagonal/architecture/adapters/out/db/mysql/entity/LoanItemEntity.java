package com.course.hexagonal.architecture.adapters.out.db.mysql.entity;

import com.course.hexagonal.architecture.domain.book.BookItem;
import com.course.hexagonal.architecture.domain.transaction.BookStatus;

import java.time.LocalDate;

public class LoanItemEntity {
    private BookItem book;
    private BookStatus loanStatusBook;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
