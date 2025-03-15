package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.query.borrow.BorrowQueryRepository;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TestBorrowQueryRepository implements BorrowQueryRepository {

    private final BorrowMapper borrowMapper;

    public TestBorrowQueryRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Override
    public BorrowDetails findById(long borrowId) {
        return TestBorrowQueryStorage.borrowsDetails.get(borrowId);
    }

    @Override
    public List<BorrowDetails> findByMemberId(long memberId) {
        return TestBorrowQueryStorage.borrowsDetails.values().stream()
                .filter(borrow -> borrow.getMember().getId() == memberId)
                .toList();
    }
}
