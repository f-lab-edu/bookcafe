package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.member.Level;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.time.LocalDate;

@EqualsAndHashCode
public class Period {
    /*
        - 대출 일자가 반납 일자보다 더 이전인 것을 보장할 책임
        - 대출 기간(대출 일자 ~ 반납 일자)을 생성할 책임
        - 연장 여부에 따라 반납 일자가 변경
            - 기본: 1주, 연장 시: 1주 추가, 총 2주
     */

    private final LocalDate from;           // 대출 일자
    private final LocalDate to;             // 반납 일자

    private Period(@NonNull LocalDate from, Level level) {
        this.from = from;
        this.to = this.from.plusWeeks(level.getBorrowPeriod());
    }

    public Period(@NonNull LocalDate from, @NonNull LocalDate to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }

    public static Period of(@NonNull LocalDate from, Level level) {
        return new Period(from, level);
    }

    public Period createExtended(Level level) {
        return new Period(from, to.plusWeeks(level.getExtendPeriod()));
    }

    public boolean isExtendable() {
        long epochDay = (from.toEpochDay() + to.toEpochDay()) / 2;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay).minusDays(1);
        LocalDate now = LocalDate.now();

        return now.isAfter(targetDate);
    }

}
