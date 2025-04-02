package com.study.bookcafe.borrow;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.borrow.BorrowService;
import com.study.bookcafe.application.command.borrow.BorrowServiceImpl;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.command.reservation.ReservationServiceImpl;
import com.study.bookcafe.application.query.borrow.BorrowQueryService;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.infrastructure.query.reservation.ReservationTestSets;
import com.study.bookcafe.query.borrow.BorrowDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BorrowTest {
    private BorrowService borrowService;

    private static BorrowRepository borrowRepository;
    private static MemberService memberService;
    private static BookInventoryService bookInventoryService;
    private static ReservationService reservationService;
    private static BorrowQueryService borrowQueryService;
    private static ReservationRepository reservationRepository;

    @BeforeAll
    public static void createTestDouble() {
        borrowRepository = mock(BorrowRepository.class);
        memberService = mock(MemberService.class);
        bookInventoryService = mock(BookInventoryService.class);
        reservationService = mock(ReservationService.class);
        borrowQueryService = mock(BorrowQueryService.class);
        reservationRepository = mock(ReservationRepository.class);
    }

    @Test
    @DisplayName("도서를 대출한다.")
    public void testBorrowBook() {
        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        BookInventory book = BookTestSets.createVegetarianBookInventory();

        when(memberService.findById(member.getId()))
                .thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId()))
                .thenReturn(book);

        // when (테스트 실행)
        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);
        borrowService.borrow(member.getId(), book.getBookId());

        var borrowCaptor = ArgumentCaptor.forClass(Borrow.class);
        verify(borrowRepository).save(borrowCaptor.capture());
        Borrow borrow = borrowCaptor.getValue();

        // then (결과 검증)
        assertThat(borrow.getMember()).isEqualTo(member);
        assertThat(borrow.getBook()).isEqualTo(book);
    }

    @Test
    @DisplayName("도서를 대출할 때 회원이 예약한 도서일 경우, 예약 제거 및 예약 카운트 차감")
    public void testBorrowReservedBook() {

        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        BookInventory book = BookTestSets.createWhiteBookInventory();
        Reservation reservation = Reservation.of(member, book);

        when(memberService.findById(member.getId())).thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId())).thenReturn(book);
        when(reservationRepository.findByMemberIdAndBookId(member.getId(), book.getBookId())).thenReturn(Optional.of(reservation));
        when(reservationRepository.findById(reservation.getId())).thenReturn(Optional.of(reservation));

        reservationService = new ReservationServiceImpl(reservationRepository, memberService, bookInventoryService);
        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);


        // when (테스트 실행)
        reservationService.reserve(member.getId(), book.getBookId());
        int beforeReservationCount = member.getReservationCount();
        book.decreaseBorrowedCount(); // book 반납

        borrowService.borrow(member.getId(), book.getBookId());

        // then (결과 검증)
        ArgumentCaptor<Reservation> reservationCaptor = ArgumentCaptor.forClass(Reservation.class);
        verify(reservationRepository).updateReservationCount(reservationCaptor.capture());
        Reservation targetReservation = reservationCaptor.getValue();

        assertThat(targetReservation.getMember()).isEqualTo(member);
        assertThat(member.getReservationCount()).isEqualTo(beforeReservationCount - 1);
    }

    @Test
    @DisplayName("회원의 대출 목록을 조회한다.")
    public void testFindBorrows() {

        long memberId = 1L;

        List<BorrowDetails> borrows = borrowQueryService.findBorrows(memberId);

        assertThat(borrows.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("도서 대출을 연장한다.")
    public void extendBorrow() {

        // before
        LocalDate targetBefore = LocalDate.now().minusDays(3);
        LocalDate targetAfter = targetBefore.plusWeeks(2);
        BorrowPeriod before = new BorrowPeriod(targetBefore, targetAfter);

        // after
        long memberId = 1L;
        long bookId = 1L;

        Optional<Borrow> targetBorrow = borrowService.findBorrowByMemberIdAndBookId(memberId, bookId, true);
        Borrow borrow = targetBorrow.orElseThrow();

        // extend borrow
        borrowService.extend(memberId, bookId);
        BorrowPeriod after = TestBorrowQueryStorage.borrowDtos.get(borrow.getId()).getBorrowPeriod();

        assertThat(before).isEqualTo(after);
    }

//    @Test
//    @DisplayName("도서를 반납한다.")
//    public void returnBook() {
//        Member member = MemberTestSets.BASIC_MEMBER;
//        Book book = BookTestSets.VEGETARIAN_BOOK;
//
//        memberService.returnBook(member.getId(), book.getId());
//        assertThat(TestBorrowQueryStorage.membersBorrowsHistory.get(member.getId()).size()).isEqualTo(1);
//    }
}
