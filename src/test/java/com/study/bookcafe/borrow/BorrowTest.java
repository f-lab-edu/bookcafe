package com.study.bookcafe.borrow;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.borrow.BorrowService;
import com.study.bookcafe.application.command.borrow.BorrowServiceImpl;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.command.reservation.ReservationServiceImpl;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.borrow.BorrowTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BorrowTest {
    private BorrowService borrowService;

    private static BorrowRepository borrowRepository;
    private static MemberService memberService;
    private static BookInventoryService bookInventoryService;
    private static ReservationService reservationService;
    private static ReservationRepository reservationRepository;

    @BeforeAll
    public static void setUp() {
        borrowRepository = mock(BorrowRepository.class);
        memberService = mock(MemberService.class);
        bookInventoryService = mock(BookInventoryService.class);
        reservationService = mock(ReservationService.class);
        reservationRepository = mock(ReservationRepository.class);
    }

    @Test
    @DisplayName("도서 대출 후 회원과 도서의 대출 건수가 증가한다.")
    public void increaseMemberAndBookBorrowCount() {
        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        Member expectedMember = MemberTestSets.createBasicMember();
        expectedMember.increaseBorrowCount();

        BookInventory book = BookTestSets.createVegetarianBookInventory();
        BookInventory expectedBook = BookTestSets.createVegetarianBookInventory();
        expectedBook.increaseBorrowedCount();

        when(memberService.findById(member.getId()))
                .thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId()))
                .thenReturn(book);
        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);

        // when (테스트 실행)
        borrowService.borrow(member.getId(), book.getBookId());

        // then (결과 검증)
        assertThat(member).isEqualTo(expectedMember);
        assertThat(book).isEqualTo(expectedBook);
    }

    @Test
    @DisplayName("도서를 대출할 때 회원이 예약한 도서일 경우, 회원의 예약 제거 및 예약 카운트가 차감된다.")
    public void testBorrowReservedBook() {

        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        BookInventory book = BookTestSets.createWhiteBookInventory();
        Reservation reservation = Reservation.of(member, book);

        when(memberService.findById(member.getId())).thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId())).thenReturn(book);
        when(reservationRepository.findByMemberIdAndBookId(member.getId(), book.getBookId())).thenReturn(Optional.of(reservation));

        reservationService = new ReservationServiceImpl(reservationRepository, memberService, bookInventoryService);
        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);

        // when (테스트 실행)
        reservationService.reserve(member.getId(), book.getBookId());
        Member expectedMember = Member.builder().id(1L).name("슈카").level(Level.BASIC).borrowCount(1).reservationCount(2).build();

        book.decreaseBorrowedCount(); // book 반납

        borrowService.borrow(member.getId(), book.getBookId());

        // then (결과 검증)
        ArgumentCaptor<Reservation> reservationCaptor = ArgumentCaptor.forClass(Reservation.class);
        verify(reservationRepository).updateReservationCount(reservationCaptor.capture());
        Reservation targetReservation = reservationCaptor.getValue();

        assertThat(targetReservation.getMember()).isEqualTo(expectedMember);
    }

    @Test
    @DisplayName("대출 연장 후 반납 기간은 회원의 등급에 따라 증가한다.")
    public void extendBorrow() {

        // given (Mock 설정)
        Member member = MemberTestSets.createBasicMember();
        BookInventory book = BookTestSets.createVegetarianBookInventory();

        LocalDateTime from = LocalDateTime.of(2025, 3, 31, 0, 0);
        Borrow borrow = Borrow.of(member, book, from);

//        BorrowPeriod expectedBorrowPeriod = new BorrowPeriod(from.toLocalDate(), from.toLocalDate()
//                .plusWeeks(Level.BASIC.getBorrowPeriod())
//                .plusWeeks(Level.BASIC.getExtendPeriod())
//        );

        BorrowPeriod expectedBorrowPeriod = BorrowPeriod.of(from.toLocalDate(), Level.BASIC).extend();

        when(memberService.findById(member.getId())).thenReturn(member);
        when(bookInventoryService.findByBookId(book.getBookId())).thenReturn(book);
        when(borrowRepository.findBorrowByMemberIdAndBookId(member.getId(), book.getBookId(), true)).thenReturn(Optional.of(borrow));

        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);

        // when (테스트 실행)
        borrowService.extend(member.getId(), book.getBookId());

        // then (결과 검증)
        ArgumentCaptor<Borrow> borrowCaptor = ArgumentCaptor.forClass(Borrow.class);
        verify(borrowRepository).updatePeriod(borrowCaptor.capture());
        Borrow targetBorrow = borrowCaptor.getValue();

        assertThat(targetBorrow.getBorrowPeriod()).isEqualTo(expectedBorrowPeriod);
    }

    @Test
    @DisplayName("도서가 반납될 때 도서에 대해 예약이 있으면, 첫번째 예약의 회원에게 우선대출권을 부여한다.")
    public void returnBook() {
        // given (Mock 설정)
        Member member1 = MemberTestSets.createWormMember();
        BookInventory book1 = BookTestSets.createWhiteBookInventory();
        Borrow borrow = BorrowTestSets.WORM_WHITE_BORROW;

        Member member2 = MemberTestSets.createBasicMember();
        BookInventory book2 = BookTestSets.createWhiteBookInventory();
        Reservation reservation = Reservation.of(member2, book2);

        when(borrowRepository.findBorrowByMemberIdAndBookId(member1.getId(), book1.getBookId())).thenReturn(Optional.of(borrow));
        when(reservationService.findFirstByBookId(book2.getBookId())).thenReturn(Optional.of(reservation));
        borrowService = new BorrowServiceImpl(borrowRepository, memberService, bookInventoryService, reservationService);

        // when (테스트 실행)
        borrowService.returnBook(member1.getId(), book1.getBookId());

        // then (결과 검증)
        ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);
        verify(memberService).save(memberCaptor.capture());
        Member member = memberCaptor.getValue();

        assertThat(member.validatePriorityBorrowForBook(book2.getBookId(), LocalDateTime.now())).isTrue();
    }
}
