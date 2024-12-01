package com.study.bookcafe.service;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.dao.MemberRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.dto.BorrowDto;
import com.study.bookcafe.dto.MemberDto;
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
     * @param member  회원
     * @param book    도서
     * @return 대출 정보
     */
    @Override
    public Borrow borrowBook(Member member, Book book) {
        MemberEntity memberEntity = memberRepository.findById(member.getId());
        member = Member.from(memberEntity);

        Borrow borrow = member.borrowBook(book);
        return borrowService.save(borrow);
    }
}