package com.study.bookcafe.application.command.member;

import com.study.bookcafe.application.command.book.BookService;
import com.study.bookcafe.application.command.borrow.BorrowService;
import com.study.bookcafe.application.exception.BorrowableException;
import com.study.bookcafe.application.exception.NonBorrowableMemberException;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BorrowService borrowService;
    private final BookService bookService;

    public MemberServiceImpl(MemberRepository memberRepository, BorrowService borrowService, BookService bookService) {
        this.memberRepository = memberRepository;
        this.borrowService = borrowService;
        this.bookService = bookService;
    }

    /**
     * 회원을 ID로 조회한다.
     *
     * @param memberId 회원 ID
     * @return 회원
     */
    @Override
    public Member findById(long memberId) {
        return memberRepository.findById(memberId);
    }

    /**
     * 회원이 도서를 대출한다.
     *
     * @param memberId 회원 ID
     * @param bookIds 도서 ID 목록
     */
    @Override
    public void borrowBook(long memberId, Collection<Long> bookIds) {
        Member member = findById(memberId);
        List<Book> books = bookService.findByIds(bookIds);
        List<Borrow> borrows = member.borrowBook(books);

        if (borrows.isEmpty()) return;

        borrowService.save(borrows);
    }

    /**
     * 회원이 도서 대출을 예약한다.
     *
     * @param memberId 회원 ID
     * @param bookId 도서 ID
     */
    @Override
    public void reserveBook(long memberId, long bookId) {
        Member member = findById(memberId);
        Book book = bookService.findById(bookId);

        // 대출 가능한 상태 -> 대출 로직으로 안내
        if (member.canBorrow() && book.canBorrow()) {
            throw new BorrowableException("해당 도서는 대출 가능한 상태입니다.");
        }

        // 도서는 대출 가능한 상태지만 회원은 대출 불가능한 상태 ->  대출 가능한 상태라고 안내
        if (book.canBorrow()) {
            throw new NonBorrowableMemberException("해당 도서는 대출 가능한 상태이지만 회원님은 대출 가능한 상태가 아닙니다.");
        }

        Reservation reservation = member.reserveBook(book);

        borrowService.save(reservation);
    }

    /**
     * 회원이 도서 예약을 취소한다.
     *
     * @param reservationId 예약 ID
     */
    @Override
    public void cancelReservation(long reservationId) {
        borrowService.cancelReservation(reservationId);
    }

}