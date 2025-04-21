package com.study.bookcafe.domain.borrow;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PriorityBorrowRight {
    long bookId;
    DateTimePeriod period;

    static final int DAY_EXPIRATION_DATE = 2;

    public PriorityBorrowRight(final long bookId, final LocalDateTime from) {
        this.bookId = bookId;
        this.period = new DateTimePeriod(from, from.plusDays(DAY_EXPIRATION_DATE));
    }

    public PriorityBorrowRight(final long bookId, final DateTimePeriod period) {
        if(!period.equalsToDays(DAY_EXPIRATION_DATE)) throw new IllegalArgumentException("우선대출권의 유효기간은 2일입니다.");

        this.bookId = bookId;
        this.period = period;
    }

    public boolean validateExpirationDate(final LocalDateTime date) {
        return period.includes(date);
    }
}
