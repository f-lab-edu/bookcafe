package com.study.bookcafe.borrow.domain.borrower;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.borrow.BorrowBusiness;

public interface Borrower {
//    BorrowBusiness borrow(BookInventory book);
    boolean isBorrowable();
    boolean haveBorrowCount();
    void increaseBorrowCount();
    void decreaseBorrowCount();
    Level getLevel();
}
