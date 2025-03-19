package com.study.bookcafe.application.command.member;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BookInventoryService bookInventoryService;

    public MemberServiceImpl(MemberRepository memberRepository, BookInventoryService bookInventoryService) {
        this.memberRepository = memberRepository;
        this.bookInventoryService = bookInventoryService;
    }

    /**
     * 회원을 ID로 조회한다.
     *
     * @param memberId 회원 ID
     * @return 회원
     */
    @Override
    public Member findById(final long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));
    }

//    @Override
//    public void returnBook(final long memberId, final long bookId) {
//        final var targetBorrow = borrowService.findBorrowByMemberIdAndBookId(memberId, bookId);
//
//        targetBorrow.ifPresent(borrow -> {
//            final Member member = findById(memberId);
//            final Return returnInfo = member.returnBook(borrow.getBook());
//
//            borrowService.save(returnInfo);
//        });
//    }

}