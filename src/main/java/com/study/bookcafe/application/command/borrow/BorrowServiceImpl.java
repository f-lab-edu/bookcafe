package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.PriorityBorrowRight;
import com.study.bookcafe.domain.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final MemberService memberService;
    private final BookInventoryService bookInventoryService;
    private final ReservationService reservationService;

    public BorrowServiceImpl(BorrowRepository borrowRepository, MemberService memberService, BookInventoryService bookInventoryService, ReservationService reservationService) {
        this.borrowRepository = borrowRepository;
        this.memberService = memberService;
        this.bookInventoryService = bookInventoryService;
        this.reservationService = reservationService;
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend) {
        return borrowRepository.findBorrowByMemberIdAndBookId(memberId, bookId, canExtend);
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(final long memberId, final long bookId) {
        return borrowRepository.findBorrowByMemberIdAndBookId(memberId, bookId);
    }

    @Override
    @Transactional
    public void borrow(final long memberId, final long bookId) {

        // 예약 순서에 따라 우선순위 적용

        /*
            도서
            - 예약

            1. 대출이 가능하고, 도서에 예약이 없을 때 : 바로 대출 가능
            2. 대출이 가능하고, 도서에 예약이 있을 때 : 우선대출 중
                - 해당 회원에게 우선대출권이 있으면 가능

         */

        Member member = memberService.findById(memberId);
        BookInventory book = bookInventoryService.findByBookId(bookId);
        Borrow borrow = Borrow.of(member, book);

        if (borrow.haveReservation()) reservationService.removeDueToBorrow(memberId, bookId);

//        borrowRepository.save(borrow);
        save(borrow);
    }

    @Override
    public void extend(final long memberId, final long bookId) {
        final var borrow = findBorrowByMemberIdAndBookId(memberId, bookId, true);

        borrow.ifPresent(targetBorrow -> {
            LocalDate now = LocalDate.now();
            targetBorrow.extendPeriod(now);

            borrowRepository.updatePeriod(targetBorrow);
        });
    }

    private void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void returnBook(long memberId, long bookId) {
        Borrow borrow = findBorrowByMemberIdAndBookId(memberId, bookId).orElseThrow(() -> new IllegalStateException("대출 정보를 찾을 수 없습니다."));

        LocalDateTime now = LocalDateTime.now();
        borrow.setReturnTime(now);

        // 도서에 대한 예약이 있다면, 예약 순서에 따라 회원에게 우선대출권 부여
        if (borrow.getBook().haveReservedCount()) {
            reservationService.findFirstByBookId(bookId).ifPresent(reservation -> {
                PriorityBorrowRight priorityBorrowRight = new PriorityBorrowRight(bookId, now);

                Member member = reservation.getMember();
                member.grant(priorityBorrowRight);
                memberService.save(member);
            });
        }

        save(borrow);
    }
}
