package com.course.hexagonal.architecture.adapters.out.db.mysql.entity;

import com.course.hexagonal.architecture.domain.admin.Client;
import com.course.hexagonal.architecture.domain.transaction.Loan;
import com.course.hexagonal.architecture.domain.transaction.LoanStatus;

import java.util.ArrayList;
import java.util.List;

public class LoanEntity {
    private long id;
    private LoanStatus loanStatus;
    private List<Loan.LoanItem> items = new ArrayList<>(); //5
    private Client client;
}
