package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.application.command.reservation.ReservationService;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Borrow;
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
        reservationService.findPriorityByMemberIdAndBookId(memberId, bookId)
                .ifPresentOrElse(reservation -> {
                    BookInventory book = reservation.getBook();
                    bookInventoryService.completePriorityBorrowReservation(book);

                    reservationService.delete(reservation);

                    Borrow borrow = Borrow.of(reservation.getMember(), book);
                    save(borrow);
                }, () -> {
                    BookInventory book = bookInventoryService.findByBookId(bookId);

                    if (book.isBorrowable()) {
                        Member member = memberService.findById(memberId);
                        Borrow borrow = Borrow.of(member, book);
                        save(borrow);
                    }
                }
            );
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
    @Transactional
    public void returnBook(final long memberId, final long bookId) {
        final var borrow = findBorrowByMemberIdAndBookId(memberId, bookId).orElseThrow(() -> new IllegalStateException("대출 정보를 찾을 수 없습니다."));
        final var now = LocalDateTime.now();

        borrow.terminate(now);
        save(borrow);

        // 우선순위 예약을 선정하여 우선대출기간 세팅
        if (borrow.getBook().haveReservedCount()) reservationService.selectPriorityReservation(borrow.getBook(), now);
    }
}
