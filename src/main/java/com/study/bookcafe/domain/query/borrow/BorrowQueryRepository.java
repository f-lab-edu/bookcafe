package com.study.bookcafe.domain.query.borrow;

import java.util.List;

public interface BorrowQueryRepository {

    BorrowDetails findById(long borrowId);
    List<BorrowDetails> findByMemberId(long memberId);

}
