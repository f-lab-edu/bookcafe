package com.study.bookcafe.reservation;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.command.reservation.ReservationServiceImpl;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.infrastructure.query.reservation.ReservationTestSets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReserveTest {

    private ReservationService reservationService;
    private static ReservationRepository reservationRepository;
    private static MemberService memberService;
    private static BookInventoryService bookInventoryService;

    @BeforeAll
    public static void setUp() {
        memberService = mock(MemberService.class);
        bookInventoryService = mock(BookInventoryService.class);
        reservationRepository = mock(ReservationRepository.class);
    }

    @Test
    @DisplayName("도서 예약 후 회원과 도서의 예약 건수가 증가한다.")
    public void increaseMemberAndBookReservationCount() {
        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        Member expectedMember = Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(0).reservationCount(2).build();
        BookInventory book = BookTestSets.createWhiteBookInventory();
        BookInventory expectedBook = BookInventory.builder().id(2L).bookId(2L).book(BookTestSets.WHITE_BOOK).stock(2).borrowedCount(2).reservedCount(2).build();

        when(memberService.findById(member.getId())).thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId())).thenReturn(book);
        reservationService = new ReservationServiceImpl(reservationRepository, memberService, bookInventoryService);

        // when (테스트 실행)
        reservationService.reserve(member.getId(), book.getBookId());

        // then (결과 검증)
        assertThat(member.getReservationCount()).isEqualTo(expectedMember.getReservationCount());
        assertThat(book.getReservedCount()).isEqualTo(expectedBook.getReservedCount());
    }

    @Test
    @DisplayName("도서 예약 취소 후 회원과 도서의 예약 건수가 차감된다.")
    public void cancelReserveTest() {
        // given (Mock 설정)
        Reservation reservation = ReservationTestSets.WORM_MEMBER_RESERVATION;
        Member member = reservation.getMember();
        Member expectedMember = Member.builder().id(2L).name("머스크").level(Level.WORM).borrowCount(3).reservationCount(1).build();
        BookInventory book = reservation.getBook();
        BookInventory expectedBook = BookInventory.builder().id(2L).bookId(2L).book(BookTestSets.WHITE_BOOK).stock(2).borrowedCount(2).reservedCount(0).build();

        when(memberService.findById(member.getId())).thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId())).thenReturn(book);
        when(reservationRepository.findById(reservation.getId())).thenReturn(Optional.of(reservation));
        reservationService = new ReservationServiceImpl(reservationRepository, memberService, bookInventoryService);

        // when (테스트 실행)
        reservationService.cancel(reservation.getId());

        // then (결과 검증)
        assertThat(member.getReservationCount()).isEqualTo(expectedMember.getReservationCount());
        assertThat(book.getReservedCount()).isEqualTo(expectedBook.getReservedCount());
    }

    @Test
    @DisplayName("회원의 예약 순서는 예약하려는 도서에 대한 예약 개수 + 1 이 된다.")
    public void setReservationOrder() {
        // given (Mock 설정)
        Reservation expectedReservation = Reservation.builder()
                .order(2)
                .build();

        Member member = MemberTestSets.createBasicMember();
        BookInventory book = BookTestSets.createWhiteBookInventory();

        // when (테스트 실행)
        Reservation reservation = Reservation.of(member, book);

        // then (결과 검증)
        assertThat(reservation.getOrder()).isEqualTo(expectedReservation.getOrder());
    }
}
