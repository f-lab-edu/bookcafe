package com.study.bookcafe.application.query.borrow;

import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.command.borrow.BorrowRepository;
import com.study.bookcafe.domain.query.borrow.BorrowQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowQueryServiceImpl implements BorrowQueryService {
    private final BorrowQueryRepository borrowQueryRepository;

    public BorrowQueryServiceImpl(BorrowQueryRepository borrowQueryRepository) {
        this.borrowQueryRepository = borrowQueryRepository;
    }

    /**
     * 대출 목록을 조회한다.
     *
     * @param memberId 회원 ID
     * @return 대출 목록
     */
    @Override
    public List<BorrowDetails> findBorrows(long memberId) {
        return borrowQueryRepository.findByMemberId(memberId);
    }

}
