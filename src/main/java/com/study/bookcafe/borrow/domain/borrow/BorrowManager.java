package com.study.bookcafe.borrow.domain.borrow;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.borrower.Borrower;
import lombok.NonNull;

public class BorrowManager {

    private final Borrower borrower;
    private final BookInventory book;

    public BorrowManager(@NonNull Borrower borrower, @NonNull BookInventory book) {
        this.borrower = borrower;
        this.book = book;
    }

    public Borrow borrow() {
        borrower.assertBorrowable();
        book.assertBorrowable();

        return Borrow.of(borrower, book);
    }

}
