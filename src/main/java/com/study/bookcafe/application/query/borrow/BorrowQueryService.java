package com.study.bookcafe.application.query.borrow;

import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.util.List;

public interface BorrowQueryService {

    // 도서 대출 조회
    List<BorrowDetails> findBorrows(long memberId);

    // 도서 예약 조회
    List<MembersReservationDetails> findMembersReservationDetails(long memberId);

}