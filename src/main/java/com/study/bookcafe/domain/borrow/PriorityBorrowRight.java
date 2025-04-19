package com.study.bookcafe.domain.borrow;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Value
public class PriorityBorrowRight {
    long bookId;
    LocalDateTime from;
    LocalDateTime to;

    static final int DAY_EXPIRATION_DATE = 2;

    public PriorityBorrowRight(long bookId, LocalDateTime from) {
        this.bookId = bookId;
        this.from = from;
        this.to = from.plusDays(DAY_EXPIRATION_DATE);
    }

    public PriorityBorrowRight(long bookId, LocalDateTime from, LocalDateTime to) {
        long between = ChronoUnit.DAYS.between(from, to);

        if(between != DAY_EXPIRATION_DATE) throw new IllegalArgumentException("우선대출권의 유효기간은 2일입니다.");

        this.bookId = bookId;
        this.from = from;
        this.to = to;
    }

    public boolean validateExpirationDate(LocalDateTime now) {
        return now.isAfter(from) && now.isBefore(to);
    }
}
