package com.study.bookcafe.domain.borrow;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PriorityBorrowPeriod {
    DateTimePeriod period;
    static final int DAY_EXPIRATION_DATE = 2;

    public PriorityBorrowPeriod(@NonNull final LocalDateTime date) {
        this.period = new DateTimePeriod(date, date.plusDays(DAY_EXPIRATION_DATE));
    }
}
