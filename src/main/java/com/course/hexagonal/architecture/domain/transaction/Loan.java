package com.course.hexagonal.architecture.domain.transaction;

import com.course.hexagonal.architecture.domain.book.BookItem;
import com.course.hexagonal.architecture.domain.admin.Client;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Loan {
    private long id;
    private LoanStatus loanStatus;
    private List<LoanItem> items = new ArrayList<>(); //5
    private Client client;

    @Data
    @Builder
    public static class LoanItem{
        private BookItem book;
        private BookStatus loanStatusBook;
        private LocalDate loanDate; //today
        private LocalDate returnDate; //today + N days
    }
}
