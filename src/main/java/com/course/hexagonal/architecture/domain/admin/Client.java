package com.course.hexagonal.architecture.domain.admin;

import com.course.hexagonal.architecture.domain.transaction.Loan;
import lombok.Data;

import java.util.List;

@Data
public class Client extends Person{


    private static final int MAX_LOANS_ALLOWED = 10;

    private List<Loan> loans;

    public boolean isLoanAllowed(){

        long totalBooks = loans.stream().mapToLong(loan -> loan.getItems().size()).sum();

        return totalBooks < MAX_LOANS_ALLOWED;
    }

}
