package com.study.bookcafe.query.borrow;

import com.study.bookcafe.query.member.MembersReservationDetails;

import java.util.List;

public interface BorrowQueryRepository {

    BorrowDetails findById(long borrowId);
    List<BorrowDetails> findByMemberId(long memberId);
    List<MembersReservationDetails> findMembersReservationDetails(long memberId);

}
