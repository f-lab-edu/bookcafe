package com.study.bookcafe.member;

import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.query.member.MemberQueryService;
import com.study.bookcafe.domain.command.book.Book;
import com.study.bookcafe.domain.command.book.Inventory;
import com.study.bookcafe.domain.command.borrow.Reservation;
import com.study.bookcafe.domain.command.member.Level;
import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.domain.query.member.MembersReservationDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ReserveTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberQueryService memberQueryService;

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

    @Test
    @DisplayName("회원의 도서 예약 목록을 조회한다.")
    public void findMembersReservationDetailsTest() {
        long memberId = 1L;
        List<MembersReservationDetails> membersReservations = memberQueryService.findMembersReservationDetails(memberId);
        assertThat(membersReservations.size()).isEqualTo(TestBorrowQueryStorage.membersReservations.get(memberId).size());
    }

    @Test
    @DisplayName("회원이 도서 예약을 취소한다.")
    public void cancelReserveTest() {
        long memberId = 1L;
        long reservationId = 1L;

        // 예약 취소
        memberService.cancelReservation(reservationId);

        // 예약 취소 후 회원의 예약 목록
        List<MembersReservationDetails> membersReservations = memberQueryService.findMembersReservationDetails(memberId);

        // 예약 목록에서 삭제됐는지 검증
        assertThat(membersReservations.stream()
                        .filter(reservation -> reservation.getId() == reservationId)
                        .count()).isEqualTo(0);

    }
}
