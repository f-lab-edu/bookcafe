package com.study.bookcafe.repository;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.entity.BookEntity;
import com.study.bookcafe.entity.BorrowEntity;
import com.study.bookcafe.entity.MemberEntity;
import com.study.bookcafe.mapper.BorrowMapper;
import org.springframework.stereotype.Repository;

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
                .book(BookEntity.builder().id(1).ISBN(9788936433598L).build()).build());
        put(2L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(2).ISBN(9788936433598L).build()).build());
        put(3L, null);
    }};

    public Borrow findById(long borrowId) {
        BorrowEntity borrowEntity = borrows.get(borrowId);
        return borrowMapper.toBorrow(borrowEntity);
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
        return borrowMapper.toBorrowList(borrowEntities);
    }
}
