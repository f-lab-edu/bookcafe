package com.study.bookcafe.domain.borrow;

import jakarta.persistence.Embedded;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PriorityBorrowPeriod {
    @Embedded
    DateTimePeriod period;

    static final int DAY_EXPIRATION_DATE = 2;

    public PriorityBorrowPeriod(@NonNull final LocalDateTime from) {
        this.period = DateTimePeriod.of(from, DAY_EXPIRATION_DATE);
    }
}
