package com.study.bookcafe.borrow.application.event;

public class BorrowEvent {
    private final long memberId;
    private final long bookId;

    public BorrowEvent(final long memberId, final long bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public long getMemberId() {
        return memberId;
    }

    public long getBookId() {
        return bookId;
    }
}
