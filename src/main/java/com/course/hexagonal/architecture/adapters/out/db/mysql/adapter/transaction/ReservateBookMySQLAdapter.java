package com.course.hexagonal.architecture.adapters.out.db.mysql.adapter.transaction;

import com.course.hexagonal.architecture.adapters.out.db.mysql.repository.transaction.LoanRepository;
import com.course.hexagonal.architecture.application.commands.LoanCommand;
import com.course.hexagonal.architecture.application.ports.in.transaction.ReservateBookUseCase;
import com.course.hexagonal.architecture.application.ports.out.transaction.LoanPort;
import com.course.hexagonal.architecture.domain.transaction.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservateBookMySQLAdapter implements LoanPort {

    private final LoanRepository loanRepository;

    @Override
    public boolean reservateBook(Loan loan) {
        return false;
    }
}
