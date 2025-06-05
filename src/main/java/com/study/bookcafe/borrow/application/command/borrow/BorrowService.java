package com.study.bookcafe.borrow.application.command.borrow;

public interface BorrowService {
    void borrow(long memberId, long bookId);
}