package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBorrowRepository implements BorrowRepository {
    Map<Long, Borrow> borrows = new HashMap<>(){{
        put(1L, Borrow.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(1).ISBN(9788936433598L).build()).build());
        put(2L, Borrow.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(2).ISBN(9788936433598L).build()).build());
        put(3L, null);
    }};

    public Borrow findById(long borrowId) {
        return borrows.get(borrowId);
    }

    public Borrow save(Borrow borrow) {
        return borrow;
    }

    @Override
    public List<Borrow> save(List<Borrow> borrowList) {
        return borrowList
                .stream().filter(borrow -> borrows.containsKey(borrow.getId()))
                .map(borrow -> borrows.get(borrow.getId())).toList();
    }
}
