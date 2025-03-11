package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.member.Level;
import lombok.NonNull;
import lombok.Value;
import java.time.LocalDate;

@Value
public class BorrowPeriod {

    Period period;

    public static BorrowPeriod of(@NonNull LocalDate from, Level level) {
        return new BorrowPeriod(from, level);
    }

    private BorrowPeriod(@NonNull LocalDate from, Level level) {
        try {
            this.period = new Period(from, from.plusWeeks(level.getBorrowPeriod()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");
        }
    }

    private BorrowPeriod(Period period) {
        this.period = period;
    }

    public BorrowPeriod(LocalDate from, LocalDate to) {
        try {
            this.period = new Period(from, to);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");
        }
    }

    public BorrowPeriod extend(Level level) {
        return new BorrowPeriod(period.extendByWeeks(level.getExtendPeriod()));
    }

    public boolean isExtendable(LocalDate now) {
        LocalDate targetDate = period.getMidDate().minusDays(1);
        return now.isAfter(targetDate);
    }

}
