package com.course.hexagonal.architecture.application.ports.out.transaction;

import com.course.hexagonal.architecture.domain.transaction.Loan;

public interface LoanPort {
    boolean reservateBook(Loan loan);

}
