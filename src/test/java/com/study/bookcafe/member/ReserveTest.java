package com.study.bookcafe.member;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.Inventory;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class ReserveTest {

    @Test
    @DisplayName("회원이 도서를 예약한다.")
    public void reserveTest() {

        Member member = Member.builder()
                .id(1)
                .name("김도훈")
                .level(Level.BASIC)
                .build();

        Book book = Book.builder()
                .id(2L)
                .ISBN(9788936433598L)
                .title("채식주의자")
                .author("한강")
                .publisher("창비")
                .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000)
                .inventory(new Inventory(5))
                .build();

        Reservation reservation = member.reserveBook(book);

        assertThat(reservation).isNotNull();
        assertThat(reservation.getMemberId()).isEqualTo(1L);
        assertThat(reservation.getBookId()).isEqualTo(2L);

    }
}
