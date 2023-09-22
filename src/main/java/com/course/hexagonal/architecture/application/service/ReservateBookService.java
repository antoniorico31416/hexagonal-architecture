package com.course.hexagonal.architecture.application.service;

import com.course.hexagonal.architecture.application.commands.LoanCommand;
import com.course.hexagonal.architecture.application.ports.in.ReservateBookUseCase;
import com.course.hexagonal.architecture.application.ports.out.CatalogBookPort;
import com.course.hexagonal.architecture.application.ports.out.InventoryBookPort;
import com.course.hexagonal.architecture.application.ports.out.ReservateBookPort;
import com.course.hexagonal.architecture.domain.Books.BookItem;
import com.course.hexagonal.architecture.domain.Books.BookState;
import com.course.hexagonal.architecture.domain.admin.Client;
import com.course.hexagonal.architecture.domain.transaction.Loan;
import com.course.hexagonal.architecture.domain.transaction.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservateBookService implements ReservateBookUseCase {

    private static final int MAX_DAYS_NEW_BOOK = 2;
    private static final int MAX_DAYS_ANTIQUE_BOOK = 5;

    CatalogBookPort catalogPort;
    ReservateBookPort reservatePort;

    InventoryBookPort inventoryPort;

    @Override
    public boolean reservateBook(LoanCommand command) {

        Loan.LoanBuilder loan = Loan.builder();
        List<Loan.LoanItem> loanItems = new ArrayList<>();

        if(!command.getClient().isLoanAllowed()){
            return false;
        }

        for (BookItem item: command.getBooks()) {
            Optional<BookItem> bookItemOpt = Optional.ofNullable(catalogPort.findBook(item.getIsbn()));

            if(bookItemOpt.isEmpty() || !bookItemOpt.get().isAvailable()){
                return false;
            }

            BookItem book = bookItemOpt.get();

            LocalDate now = LocalDate.now();

            LocalDate returnDate = book.getState() == BookState.NEW ? now.plusDays(MAX_DAYS_NEW_BOOK)
                    : now.plusDays(MAX_DAYS_ANTIQUE_BOOK);

            //ShedLock
            Loan.LoanItem loanItem = Loan.LoanItem.builder().loanDate(now).book(book).
                    returnDate(returnDate).statusBook(Status.BORROWED).build();

            loanItems.add(loanItem);
        }

        //update book inventory
        //inventoryPort.updateInventoryBook(book.getIsbn(), 1);

        loan.client(command.getClient()).loanStatus(Status.IN_PROGRESS).items(loanItems).build();


        return true;
    }


}
