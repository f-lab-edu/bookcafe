package com.study.bookcafe.infrastructure.borrow;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.infrastructure.book.BookEntity;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.infrastructure.member.MemberEntity;
import com.study.bookcafe.domain.borrow.BorrowDetails;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBorrowRepository implements BorrowRepository {

    private final BorrowMapper borrowMapper;

    public TestBorrowRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    Map<Long, BorrowEntity> borrows = new HashMap<>(){{
        put(1L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(1).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(2L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(2).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(3L, null);
    }};

    Map<Long, BorrowDetails> borrowDetails = new HashMap<>(){{
        put(1L, BorrowDetails.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(1).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(2L, BorrowDetails.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(2).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
    }};

    public Borrow findById(long borrowId) {
        BorrowEntity borrowEntity = borrows.get(borrowId);
        return borrowMapper.toBorrow(borrowEntity);
    }

    @Override
    public List<BorrowDetails> findByMemberId(long memberId) {
        return borrowDetails.values().stream()
                .filter(borrow -> borrow.getMember().getId() == memberId)
                .toList();
    }

    public Borrow save(Borrow borrow) {
        BorrowEntity borrowEntity = borrows.get(borrow.getId());
        return borrowMapper.toBorrow(borrowEntity);
    }

    @Override
    public List<Borrow> save(Collection<Borrow> borrows) {
        List<BorrowEntity> borrowEntities = borrows
                .stream().filter(borrow -> this.borrows.containsKey(borrow.getId()))
                .map(borrow -> this.borrows.get(borrow.getId())).toList();
        return borrowMapper.toBorrows(borrowEntities);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservation;
    }
}
