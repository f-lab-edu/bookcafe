package com.study.bookcafe.borrow;

import com.study.bookcafe.vo.Period;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class PeriodTest {

    LocalDateTime date1 = LocalDateTime.of(2024, 12, 7, 12, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2024, 12, 8, 12, 0, 0);

    @Test
    @DisplayName("반납일자는 대출일자보다 이후여야 한다.")
    public void createPeriodTest() {
        Period period1 = new Period(date1, date2);
        Period period2 = new Period(date2, date2);

        assertThat(period1).isNotNull();
        assertThat(period2).isNotNull();
    }

    @Test
    @DisplayName("반납일자가 대출일자보다 이전이거나 반납일자 또는 대출일자가 null이면 예외가 발생한다.")
    public void createPeriodExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(date2, date1));
        Assertions.assertThrows(NullPointerException.class, () -> new Period(null, null));
    }
}
