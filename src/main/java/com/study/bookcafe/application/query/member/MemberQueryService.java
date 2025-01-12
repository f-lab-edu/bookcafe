package com.study.bookcafe.application.query.member;

import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.util.List;

public interface MemberQueryService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출 조회
    List<BorrowDetails> findBorrows(long memberId);

    // 도서 예약 조회
    List<MembersReservationDetails> findMembersReservationDetails(long memberId);
}
