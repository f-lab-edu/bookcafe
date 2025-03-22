package com.study.bookcafe.borrow;

import com.study.bookcafe.application.command.borrow.BorrowService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.application.query.borrow.BorrowQueryService;
import com.study.bookcafe.application.query.member.MemberQueryService;
import com.study.bookcafe.book.BookTest;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.infrastructure.query.reservation.ReservationTestSets;
import com.study.bookcafe.infrastructure.query.reservation.TestReservationQueryStorage;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.query.borrow.BorrowDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BorrowTest {
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BorrowQueryService borrowQueryService;
    @Autowired
    private ReservationService reservationService;

    @Test
    @DisplayName("도서를 대출한다.")
    public void testBorrowBook() {

        long memberId = 1;
        long bookId = 1;

        borrowService.borrow(memberId, bookId);

        List<BorrowDetails> borrows = borrowQueryService.findBorrows(memberId);

        borrows.forEach(borrow -> assertThat(borrow.getMember().getId()).isEqualTo(memberId));
    }

    @Test
    @DisplayName("도서를 대출할 때 회원이 예약한 도서일 경우, 예약 제거 및 예약 카운트 감소")
    public void testBorrowReservedBook() {

        Member member1 = MemberTestSets.BASIC_MEMBER;
        BookInventory book1 = BookTestSets.HANRIVER_BOOK_INVENTORY;
        member1.increaseReservationCount();

        Member member2 = MemberTestSets.WORM_MEMBER;
        BookInventory book2 = BookTestSets.WHITE_BOOK_INVENTORY;
        member2.increaseReservationCount();

        // member1 -> book1 예약
        reservationService.reserve(member1.getId(), book1.getBookId());
        // member2 -> book2 예약
        reservationService.reserve(member2.getId(), book2.getBookId());

        // book2 반납 (임시)
        BookTestSets.WHITE_BOOK_INVENTORY.decreaseBorrowedCount();

        // member1 -> book2 대출
        borrowService.borrow(member1.getId(), book2.getBookId());

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
