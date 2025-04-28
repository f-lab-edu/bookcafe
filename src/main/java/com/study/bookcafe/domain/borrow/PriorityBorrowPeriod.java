package com.study.bookcafe.domain.borrow;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PriorityBorrowPeriod {
    DateTimePeriod period;

    static final int DAY_EXPIRATION_DATE = 2;

    public PriorityBorrowPeriod(@NonNull final LocalDateTime from) {
        this.period = DateTimePeriod.of(from, DAY_EXPIRATION_DATE);
    }
}
