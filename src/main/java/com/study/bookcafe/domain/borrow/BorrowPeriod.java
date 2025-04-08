package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.member.Level;
import lombok.NonNull;
import lombok.Value;
import java.time.LocalDate;

@Value
public class BorrowPeriod {

    Period period;
    Level level;

    public static BorrowPeriod of(@NonNull LocalDate from, @NonNull Level level) {
        return new BorrowPeriod(from, level);
    }
    public static BorrowPeriod of(@NonNull Period period, @NonNull Level level) {
        return new BorrowPeriod(period, level);
    }

    public BorrowPeriod(@NonNull LocalDate from, @NonNull Level level) {
        try {
            this.period = new Period(from, from.plusWeeks(level.getBorrowPeriod()));
            this.level = level;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");
        }
    }

    private BorrowPeriod(@NonNull Period period, @NonNull Level level) {
        this.period = period;
        this.level = level;
    }

    public BorrowPeriod extend() {
        return new BorrowPeriod(period.extendByWeeks(level.getExtendPeriod()), level);
    }

    public boolean isExtendable(@NonNull LocalDate now) {
        LocalDate targetDate = period.getMidDate().minusDays(1);
        return now.isAfter(targetDate);
    }

}
