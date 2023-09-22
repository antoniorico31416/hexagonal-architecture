package com.course.hexagonal.architecture.application.ports.in;

import com.course.hexagonal.architecture.application.commands.LoanCommand;
import com.course.hexagonal.architecture.domain.admin.Client;

public interface ReservateBookUseCase {

    boolean reservateBook(LoanCommand command);
}
