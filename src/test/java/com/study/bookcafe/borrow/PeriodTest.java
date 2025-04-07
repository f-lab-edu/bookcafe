package com.study.bookcafe.borrow;

import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.member.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PeriodTest {

    private final LocalDate date1 = LocalDate.of(2024, 12, 7);
    private final LocalDate date2 = LocalDate.of(2024, 12, 8);

    @Test
    @DisplayName("반납일자는 대출일자보다 이후여야 한다.")
    public void returnDateMustBeLaterThanTheBorrowDate() {
        BorrowPeriod period1 = new BorrowPeriod(date1, date2);
        BorrowPeriod period2 = new BorrowPeriod(date2, date2);

        assertThat(period1).isNotNull();
        assertThat(period2).isNotNull();
    }

    @Test
    @DisplayName("반납일자가 대출일자보다 이전이거나 반납일자 또는 대출일자가 null이면 예외가 발생한다.")
    public void exceptionOccursIfReturnDateIsEarlierThanBorrowDateOrIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BorrowPeriod(date2, date1));
        Assertions.assertThrows(NullPointerException.class, () -> new BorrowPeriod(null, null));
    }

    @Test
    @DisplayName("대출 연장은 회원 등급에 따라 반납 기간이 연장된다.")
    public void checkBorrowExtensionsPeriodByMemberShipLevel() {
        LocalDate borrowDate = LocalDate.now();

        BorrowPeriod basicExtendedPeriod = new BorrowPeriod(borrowDate, borrowDate
                .plusWeeks(Level.BASIC.getBorrowPeriod())
                .plusWeeks(Level.BASIC.getExtendPeriod())
        );
        BorrowPeriod wormExtendedPeriod = new BorrowPeriod(borrowDate, borrowDate
                .plusWeeks(Level.WORM.getBorrowPeriod())
                .plusWeeks(Level.WORM.getExtendPeriod())
        );
        BorrowPeriod librarianExtendedPeriod = new BorrowPeriod(borrowDate, borrowDate
                .plusWeeks(Level.LIBRARIAN.getBorrowPeriod())
                .plusWeeks(Level.LIBRARIAN.getExtendPeriod())
        );

        BorrowPeriod basicExpectedPeriod = BorrowPeriod.of(borrowDate, Level.BASIC).extend(Level.BASIC);
        BorrowPeriod wormExpectedPeriod = BorrowPeriod.of(borrowDate, Level.WORM).extend(Level.WORM);
        BorrowPeriod librarianExpectedPeriod = BorrowPeriod.of(borrowDate, Level.LIBRARIAN).extend(Level.LIBRARIAN);

        assertThat(basicExtendedPeriod).isEqualTo(basicExpectedPeriod);
        assertThat(wormExtendedPeriod).isEqualTo(wormExpectedPeriod);
        assertThat(librarianExtendedPeriod).isEqualTo(librarianExpectedPeriod);

    }

    @Test
    @DisplayName("대출 연장은 대출 기간의 50%가 경과해야 가능하다.")
    public void checkPassHalfOfBorrowPeriod() {
        LocalDate now = LocalDate.now();

        BorrowPeriod period1 = BorrowPeriod.of(now.minusDays(3), Level.BASIC);
        BorrowPeriod period2 = BorrowPeriod.of(now.minusDays(2), Level.BASIC);
        BorrowPeriod period3 = BorrowPeriod.of(now.minusDays(7), Level.WORM);
        BorrowPeriod period4 = BorrowPeriod.of(now.minusDays(6), Level.WORM);

        assertThat(period1.isExtendable(now)).isTrue();
        assertThat(period2.isExtendable(now)).isFalse();
        assertThat(period3.isExtendable(now)).isTrue();
        assertThat(period4.isExtendable(now)).isFalse();
    }
}
