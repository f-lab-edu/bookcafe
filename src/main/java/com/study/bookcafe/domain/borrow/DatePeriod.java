package com.study.bookcafe.domain.borrow;

import jakarta.persistence.Column;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class DatePeriod {

    @Column(name = "\"from\"")
    LocalDate from;           // 시작 일자
    @Column(name = "\"to\"")
    LocalDate to;             // 종료 일자

    public static DatePeriod of(@NonNull final LocalDate from, final int weeks) {
        return new DatePeriod(from, from.plusWeeks(weeks));
    }

    public DatePeriod(@NonNull final LocalDate from, @NonNull final LocalDate to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("종료 일자는 시작 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }

    public DatePeriod extendByWeeks(final int addWeeks) {
        return new DatePeriod(from, to.plusWeeks(addWeeks));
    }

    public LocalDate getMidDate() {
        long epochDay = (from.toEpochDay() + to.toEpochDay()) / 2;
        return LocalDate.ofEpochDay(epochDay);
    }
}
