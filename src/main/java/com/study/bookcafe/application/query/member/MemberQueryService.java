package com.study.bookcafe.application.query.member;

import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.interfaces.member.MembersReservationDetails;

import java.util.List;

public interface MemberQueryService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출 조회
    List<BorrowDetails> findBorrows(long memberId);

    // 도서 예약 조회
    List<MembersReservationDetails> findReservations(long memberId);
}
