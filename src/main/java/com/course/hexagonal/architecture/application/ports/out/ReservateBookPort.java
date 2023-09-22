package com.course.hexagonal.architecture.application.ports.out;

import com.course.hexagonal.architecture.domain.transaction.Loan;

public interface ReservateBookPort {
    boolean reserveBook(Loan loan);

}
