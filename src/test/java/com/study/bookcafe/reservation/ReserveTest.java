package com.study.bookcafe.reservation;

import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.query.reservation.ReservationQueryService;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.infrastructure.query.reservation.TestReservationQueryStorage;
import com.study.bookcafe.query.reservation.ReservationView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ReserveTest {

    @Autowired
    private ReservationQueryService reservationQueryService;
    @Autowired
    private ReservationService reservationService;

    @Test
    @DisplayName("도서를 예약한다.")
    public void reserveTest() {

        Member member = MemberTestSets.BASIC_MEMBER;
        Book book = BookTestSets.VEGETARIAN_BOOK;

        Assertions.assertThrows(IllegalStateException.class, () -> reservationService.reserve(member.getId(), book.getId()));
    }

    @Test
    @DisplayName("도서 예약 목록을 조회한다.")
    public void findMembersReservationDetailsTest() {
        long memberId = MemberTestSets.BASIC_MEMBER.getId();
        List<ReservationView> membersReservations = reservationQueryService.findMembersReservationDetails(memberId);
        assertThat(membersReservations.size()).isEqualTo(TestReservationQueryStorage.membersReservationViews.get(memberId).size());
    }

    @Test
    @DisplayName("도서 예약을 취소한다.")
    public void cancelReserveTest() {
        long memberId = 1L;
        long reservationId = 1L;

        // 예약 취소
        reservationService.cancelReservation(reservationId);

        // 예약 취소 후 회원의 예약 목록
        List<ReservationView> membersReservations = reservationQueryService.findMembersReservationDetails(memberId);

        // 예약 목록에서 삭제됐는지 검증
        assertThat(membersReservations.stream()
                        .filter(reservation -> reservation.getId() == reservationId)
                        .count()).isEqualTo(0);

    }
}
