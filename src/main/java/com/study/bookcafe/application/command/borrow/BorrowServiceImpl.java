package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.application.command.book.BookService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.Return;
import com.study.bookcafe.domain.member.Member;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final MemberService memberService;
    private final BookService bookService;

    public BorrowServiceImpl(BorrowRepository borrowRepository, MemberService memberService, BookService bookService) {
        this.borrowRepository = borrowRepository;
        this.memberService = memberService;
        this.bookService = bookService;
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
    public void borrow(long memberId, long bookId) {
        Member member = memberService.findById(memberId);
        Book book = bookService.findById(bookId);

        Borrow.of(member, book).ifPresent(borrowRepository::save);
    }

    @Override
    public void extend(long memberId, long bookId) {
        final var borrow = findBorrowByMemberIdAndBookId(memberId, bookId, true);

        borrow.ifPresent(targetBorrow -> {
            LocalDate now = LocalDate.now();
            targetBorrow.extendPeriod(now);

            borrowRepository.updatePeriod(targetBorrow);
        });
    }

    /**
     * 새로운 예약을 저장한다.
     *
     * @param reservation 예악 정보
     */
    @Override
    public void save(Reservation reservation) {
        borrowRepository.save(reservation);
    }

    /**
     * 예약을 취소한다.
     *
     * @param reservationId 예약 ID
     */
    @Override
    public void cancelReservation(long reservationId) {
        borrowRepository.cancelReservation(reservationId);
    }

    @Override
    public void save(final Return returnInfo) {
        borrowRepository.save(returnInfo);
    }

}
