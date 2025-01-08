package com.study.bookcafe.application.query.borrow;

import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.interfaces.member.MembersReservationDetails;

import java.util.List;

public interface BorrowQueryService {

    // 도서 대출 조회
    List<BorrowDetails> findBorrows(long memberId);

    // 도서 예약 조회
    List<MembersReservationDetails> findMembersReservations(long memberId);

}