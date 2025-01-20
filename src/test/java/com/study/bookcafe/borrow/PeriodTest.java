package com.study.bookcafe.borrow;

import com.study.bookcafe.domain.borrow.Period;
import com.study.bookcafe.domain.member.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PeriodTest {

    LocalDate date1 = LocalDate.of(2024, 12, 7);
    LocalDate date2 = LocalDate.of(2024, 12, 8);

    @Test
    @DisplayName("반납일자는 대출일자보다 이후여야 한다.")
    public void ofTest() {
        Period period1 = new Period(date1, date2);
        Period period2 = new Period(date2, date2);

        assertThat(period1).isNotNull();
        assertThat(period2).isNotNull();
    }

    @Test
    @DisplayName("반납일자가 대출일자보다 이전이거나 반납일자 또는 대출일자가 null이면 예외가 발생한다.")
    public void ofExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(date2, date1));
        Assertions.assertThrows(NullPointerException.class, () -> new Period(null, null));
    }

    @Test
    @DisplayName("회원 등급에 따라 대출 연장 기간을 확인한다,")
    public void checkBorrowExtensionsPeriodByMemberShipLevel() {
        LocalDate borrowDate = LocalDate.now();

        Period basicExtendedPeriod = Period.of(borrowDate, Level.BASIC).createExtended(Level.BASIC);
        Period wormExtendedPeriod = Period.of(borrowDate, Level.WORM).createExtended(Level.WORM);
        Period librarianExtendedPeriod = Period.of(borrowDate, Level.LIBRARIAN).createExtended(Level.LIBRARIAN);

        Period newBasicPeriod = new Period(borrowDate, borrowDate.plusWeeks(Level.BASIC.getBorrowPeriod()).plusWeeks(Level.BASIC.getExtendPeriod()));
        Period newWormPeriod = new Period(borrowDate, borrowDate.plusWeeks(Level.WORM.getBorrowPeriod()).plusWeeks(Level.WORM.getExtendPeriod()));
        Period newLibrarianPeriod = new Period(borrowDate, borrowDate.plusWeeks(Level.LIBRARIAN.getBorrowPeriod()).plusWeeks(Level.LIBRARIAN.getExtendPeriod()));

        assertThat(basicExtendedPeriod).isEqualTo(newBasicPeriod);
        assertThat(wormExtendedPeriod).isEqualTo(newWormPeriod);
        assertThat(librarianExtendedPeriod).isEqualTo(newLibrarianPeriod);

    }

    @Test
    @DisplayName("대출 연장은 대출 기간의 50%가 경과해야 가능하다.")
    public void checkPassHalfOfBorrowPeriod() {
        LocalDate now = LocalDate.now();

        Period period1 = Period.of(now.minusDays(3), Level.BASIC);
        Period period2 = Period.of(now.minusDays(2), Level.BASIC);
        Period period3 = Period.of(now.minusDays(7), Level.WORM);
        Period period4 = Period.of(now.minusDays(6), Level.WORM);

        assertThat(period1.isExtendable()).isTrue();
        assertThat(period2.isExtendable()).isFalse();
        assertThat(period3.isExtendable()).isTrue();
        assertThat(period4.isExtendable()).isFalse();
    }
}
