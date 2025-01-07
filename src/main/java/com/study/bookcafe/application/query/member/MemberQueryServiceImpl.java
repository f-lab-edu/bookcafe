package com.study.bookcafe.application.query.member;

import com.study.bookcafe.application.query.borrow.BorrowQueryService;
import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.domain.command.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final BorrowQueryService borrowService;

    public MemberQueryServiceImpl(MemberRepository memberRepository, BorrowQueryService borrowService) {
        this.memberRepository = memberRepository;
        this.borrowService = borrowService;
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
     * 회원의 대출 목록을 조회한다.
     *
     * @param memberId 회원 ID
     * @return 대출 목록
     */
    @Override
    public List<BorrowDetails> findBorrows(long memberId) {
        return borrowService.findBorrows(memberId);
    }
}