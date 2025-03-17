package com.study.bookcafe.reservation;

import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.query.reservation.ReservationQueryService;
import com.study.bookcafe.domain.book.BookInventory;
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
        BookInventory book = BookTestSets.VEGETARIAN_BOOK_INVENTORY;

        Assertions.assertThrows(IllegalStateException.class, () -> reservationService.reserve(member.getId(), book.getBookId()));
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
        long reservationId_1 = 1L;
        long reservationId_2 = 10L;

        // 예약 확인
        assertThat(reservationService.findById(reservationId_1)).isNotNull();

        // 예약 취소
        reservationService.cancel(reservationId_1);

        // 예약 목록에서 삭제됐는지 검증
        assertThatThrownBy(() -> reservationService.findById(reservationId_1)).isInstanceOf(IllegalArgumentException.class);

        // 존재하지 않는 예약 번호로 조회
        assertThatThrownBy(() -> reservationService.cancel(reservationId_2)).isInstanceOf(IllegalArgumentException.class);
    }
}
