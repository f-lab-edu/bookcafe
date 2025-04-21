package com.study.bookcafe.domain.borrow;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Value
public class DateTimePeriod {
    LocalDateTime from;
    LocalDateTime to;

    public DateTimePeriod(@NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("종료 일자는 시작 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }

    public boolean includes(@NonNull final LocalDateTime date) {
        return from.isBefore(date) && to.isAfter(date);
    }

    public boolean equalsToDays(final int between) {
        return ChronoUnit.DAYS.between(from, to) == between;
    }
}
