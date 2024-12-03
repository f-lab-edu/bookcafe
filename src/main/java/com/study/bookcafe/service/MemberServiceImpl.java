package com.study.bookcafe.service;

import com.study.bookcafe.dao.MemberRepository;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.entity.MemberEntity;
import com.study.bookcafe.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BorrowService borrowService;
    private final BookService bookService;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, BorrowService borrowService, BookService bookService, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.borrowService = borrowService;
        this.bookService = bookService;
        this.memberMapper = memberMapper;
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
        return memberMapper.toMember(memberEntity);
    }

    /**
     * 회원이 도서를 대출한다.
     *
     * @param memberId      회원 ID
     * @param bookIdList    도서 ID 목록
     * @return 대출 정보
     */
    @Override
    public List<Borrow> borrowBook(long memberId, List<Long> bookIdList) {
        Member member = findById(memberId);
        List<Book> bookList = bookService.findByIdList(bookIdList);
        List<Borrow> borrowList = member.borrowBook(bookList);

        if(borrowList.isEmpty()) return borrowList;

        return borrowService.save(borrowList);
    }
}