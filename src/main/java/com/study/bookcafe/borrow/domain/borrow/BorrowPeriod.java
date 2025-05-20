package com.study.bookcafe.borrow.domain.borrow;

import com.study.bookcafe.borrow.domain.member.Level;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class BorrowPeriod {

    DatePeriod period;
    Level level;

    public static BorrowPeriod of(@NonNull final LocalDate from, @NonNull final Level level) {
        return new BorrowPeriod(from, level);
    }
    public static BorrowPeriod of(@NonNull final DatePeriod period, @NonNull final Level level) {
        return new BorrowPeriod(period, level);
    }

    private BorrowPeriod(@NonNull final LocalDate from, @NonNull final Level level) {
        try {
            this.period = DatePeriod.of(from, level.getBorrowPeriod());
            this.level = level;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");
        }
    }

    private BorrowPeriod(@NonNull final DatePeriod period, @NonNull final Level level) {
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
