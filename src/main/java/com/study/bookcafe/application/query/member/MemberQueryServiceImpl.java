package com.study.bookcafe.application.query.member;

import com.study.bookcafe.application.query.borrow.BorrowQueryService;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.member.MemberRepository;
import com.study.bookcafe.query.member.MemberQueryRepository;
import com.study.bookcafe.query.member.MemberView;
import com.study.bookcafe.query.member.MembersReservationDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberQueryRepository memberQueryRepository;
    private final BorrowQueryService borrowQueryService;

    public MemberQueryServiceImpl(MemberQueryRepository memberQueryRepository, BorrowQueryService borrowQueryService) {
        this.memberQueryRepository = memberQueryRepository;
        this.borrowQueryService = borrowQueryService;
    }

    /**
     * 회원을 ID로 조회한다.
     *
     * @param memberId 회원 ID
     * @return 회원
     */
    @Override
    public MemberView findById(long memberId) {
        return memberQueryRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));
    }
}