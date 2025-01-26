package com.study.bookcafe.domain.borrow;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.time.LocalDate;

@EqualsAndHashCode
public class Period {

    private final LocalDate from;           // 시작 일자
    private final LocalDate to;             // 종료 일자

    public Period(@NonNull LocalDate from, @NonNull LocalDate to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("시작 일자는 종료 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }

    public Period extendByWeeks(int addWeeks) {
        return new Period(from, to.plusWeeks(addWeeks));
    }

    public LocalDate getMidDate() {
        long epochDay = (from.toEpochDay() + to.toEpochDay()) / 2;
        return LocalDate.ofEpochDay(epochDay);
    }


}
