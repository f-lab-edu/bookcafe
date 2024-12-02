package com.study.bookcafe.service;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.dao.MemberRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.entity.BookEntity;
import com.study.bookcafe.entity.MemberEntity;

public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;
    TestBookRepository bookRepository;
    BorrowService borrowService;
    BookService bookService;

    public MemberServiceImpl(MemberRepository memberRepository, TestBookRepository bookRepository, BorrowService borrowService, BookService bookService) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
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
        MemberEntity memberEntity = memberRepository.findById(memberId);
        return Member.from(memberEntity);
    }

    /**
     * 회원이 도서를 대출한다.
     *
     * @param memberId  회원 ID
     * @param bookId    도서 ID
     * @return 대출 정보
     */
    @Override
    public Borrow borrowBook(long memberId, long bookId) {
        MemberEntity memberEntity = memberRepository.findById(memberId);
        Member member = Member.from(memberEntity);

        BookEntity bookEntity = bookRepository.findById(bookId);
        Book book = Book.from(bookEntity);

        Borrow borrow = member.borrowBook(book);
        return borrowService.save(borrow);
    }
}