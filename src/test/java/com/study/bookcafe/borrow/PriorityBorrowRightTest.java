package com.study.bookcafe.borrow;

import com.study.bookcafe.domain.borrow.PriorityBorrowRight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class PriorityBorrowRightTest {

    @Test
    @DisplayName("우선 대출권의 유효기간은 부여받은 시간부터 2일이다.")
    public void validateExpirationDate() {
        long bookId = 1L;
        LocalDateTime now = LocalDateTime.now();

        PriorityBorrowRight priorityBorrowRight = new PriorityBorrowRight(bookId, now);
        PriorityBorrowRight expectedPriorityBorrowRight = new PriorityBorrowRight(bookId, now, now.plusDays(2));

        assertThat(priorityBorrowRight).isEqualTo(expectedPriorityBorrowRight);
    }
}
