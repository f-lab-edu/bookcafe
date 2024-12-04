package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BookEntity;
import com.study.bookcafe.entity.BorrowEntity;
import com.study.bookcafe.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBorrowRepository implements BorrowRepository {
    Map<Long, BorrowEntity> borrows = new HashMap<>(){{
        put(1L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(1).ISBN(9788936433598L).build()).build());
        put(2L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(2).ISBN(9788936433598L).build()).build());
        put(3L, null);
    }};

    public BorrowEntity findById(long borrowId) {
        return borrows.get(borrowId);
    }

    public BorrowEntity save(BorrowEntity borrowEntity) {
        return borrowEntity;
    }

    @Override
    public List<BorrowEntity> save(List<BorrowEntity> borrowEntityList) {
        return borrowEntityList
                .stream().filter(borrow -> borrows.containsKey(borrow.getId()))
                .map(borrow -> borrows.get(borrow.getId())).toList();
    }
}
