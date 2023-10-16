package com.course.hexagonal.architecture.application.service.transaction;

import com.course.hexagonal.architecture.application.commands.LoanCommand;
import com.course.hexagonal.architecture.application.ports.in.transaction.ReservateBookUseCase;
import com.course.hexagonal.architecture.application.ports.out.book.CatalogBookPort;
import com.course.hexagonal.architecture.application.ports.out.book.InventoryBookPort;
import com.course.hexagonal.architecture.application.ports.out.transaction.LoanPort;
import com.course.hexagonal.architecture.domain.book.BookItem;
import com.course.hexagonal.architecture.domain.book.BookState;
import com.course.hexagonal.architecture.domain.transaction.BookStatus;
import com.course.hexagonal.architecture.domain.transaction.Loan;
import com.course.hexagonal.architecture.domain.transaction.LoanStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservateBookService implements ReservateBookUseCase {

    private static final int MAX_DAYS_NEW_BOOK = 2;
    private static final int MAX_DAYS_ANTIQUE_BOOK = 5;

    private final CatalogBookPort catalogPort;
    private final LoanPort reservatePort;
    private final InventoryBookPort inventoryPort;

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
                    returnDate(returnDate).loanStatusBook(BookStatus.BORROWED).build();

            loanItems.add(loanItem);
        }

        //update book inventory
        for(Loan.LoanItem item: loanItems){
            inventoryPort.updateInventoryBook(item.getBook().getIsbn(), 1);
        }

        return reservatePort.reservateBook(loan.client(command.getClient()).loanStatus(LoanStatus.IN_PROGRESS).items(loanItems).build());
    }


}
