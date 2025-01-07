package com.study.bookcafe.infrastructure.command.borrow;

import com.study.bookcafe.domain.command.borrow.Reservation;
import com.study.bookcafe.domain.command.borrow.Borrow;
import com.study.bookcafe.domain.command.borrow.BorrowRepository;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.borrow.BorrowEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
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

    public void save(Borrow borrow) {
        BorrowEntity borrowEntity = borrows.get(borrow.getId());
        borrowMapper.toBorrow(borrowEntity);
    }

    @Override
    public void save(Collection<Borrow> borrows) {
        List<BorrowEntity> borrowEntities = borrows
                .stream().filter(borrow -> this.borrows.containsKey(borrow.getId()))
                .map(borrow -> this.borrows.get(borrow.getId())).toList();
        borrowMapper.toBorrows(borrowEntities);
    }

    @Override
    public void save(Reservation reservation) {

    }
}
