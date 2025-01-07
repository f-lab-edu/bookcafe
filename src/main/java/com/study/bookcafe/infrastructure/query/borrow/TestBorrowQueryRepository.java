package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.query.book.BookView;
import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.query.borrow.BorrowQueryRepository;
import com.study.bookcafe.domain.query.member.MemberView;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBorrowQueryRepository implements BorrowQueryRepository {

    private final BorrowMapper borrowMapper;

    public TestBorrowQueryRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    Map<Long, BorrowDetails> borrowsDetails = new HashMap<>(){{
        put(1L, BorrowDetails.builder()
                .member(MemberView.builder().id(1).build())
                .book(BookView.builder().id(1).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(2L, BorrowDetails.builder()
                .member(MemberView.builder().id(1).build())
                .book(BookView.builder().id(2).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
    }};

    @Override
    public BorrowDetails findById(long borrowId) {
        return borrowsDetails.get(borrowId);
    }

    @Override
    public List<BorrowDetails> findByMemberId(long memberId) {
        return borrowsDetails.values().stream()
                .filter(borrow -> borrow.getMember().getId() == memberId)
                .toList();
    }

}
