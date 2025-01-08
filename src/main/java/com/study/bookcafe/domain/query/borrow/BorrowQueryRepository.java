package com.study.bookcafe.domain.query.borrow;

import com.study.bookcafe.interfaces.member.MembersReservationDetails;

import java.util.List;

public interface BorrowQueryRepository {

    BorrowDetails findById(long borrowId);
    List<BorrowDetails> findByMemberId(long memberId);
    List<MembersReservationDetails> findMembersReservationDetails(long memberId);

}
