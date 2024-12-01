package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.entity.BorrowEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TestBorrowRepository implements BorrowRepository {
    Map<Long, BorrowEntity> borrows = new HashMap<>(){{
        put(1L, BorrowEntity.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(1).ISBN(9788936433598L).build()).build());
        put(2L, BorrowEntity.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(2).ISBN(9788936433598L).build()).build());
        put(3L, null);
    }};

    public BorrowEntity find(BorrowEntity borrowEntity) {
        return borrows.get(borrowEntity.getMember().getId());
    }

    public BorrowEntity save(BorrowEntity borrowEntity) {
        return borrowEntity;
    }
}
