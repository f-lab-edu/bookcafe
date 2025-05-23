package com.study.bookcafe.domain.borrow;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class DateTimePeriod {

    LocalDateTime from;
    LocalDateTime to;

    public static DateTimePeriod of(@NonNull final LocalDateTime from, final int days) {
        return new DateTimePeriod(from, from.plusDays(days));
    }

    public DateTimePeriod(@NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("종료 일자는 시작 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }
}
