package com.course.hexagonal.architecture.adapters.out.db.mysql.repository.transaction;

import com.course.hexagonal.architecture.adapters.out.db.mysql.entity.LoanEntity;
import com.course.hexagonal.architecture.domain.transaction.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    boolean reservateBook(Loan loan);
}
