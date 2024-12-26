package com.study.bookcafe.application.member;

import com.study.bookcafe.application.book.BookService;
import com.study.bookcafe.application.borrow.BorrowService;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.MemberRepository;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.member.Member;
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
     * @return 대출
     */
    @Override
    public List<Borrow> borrowBook(long memberId, Collection<Long> bookIds) {
        Member member = findById(memberId);
        List<Book> books = bookService.findByIds(bookIds);
        List<Borrow> borrows = member.borrowBook(books);

        if (borrows.isEmpty()) return borrows;

        return borrowService.save(borrows);
    }

    /**
     * 회원이 도서 대출을 예약한다.
     * @param memberId 회원 ID
     * @param bookId 도서 ID
     * @return 예약
     */
    @Override
    public Reservation reserveBook(long memberId, long bookId) {
        Member member = findById(memberId);
        Book book = bookService.findById(bookId);

        Reservation reservation = member.reserveBook(book);

        return borrowService.save(reservation);
    }


}