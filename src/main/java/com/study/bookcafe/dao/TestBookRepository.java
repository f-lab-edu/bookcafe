package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Inventory;
import com.study.bookcafe.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBookRepository implements BookRepository {
    public static Map<Long, BookEntity> books = new HashMap<>(){{
        put(1L, BookEntity.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build());
        put(2L, BookEntity.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
                .price(13000).inventory(new Inventory(0)).build());
    }};

    public BookEntity findById(long bookId) {
        return books.get(bookId);
    }

    @Override
    public List<BookEntity> findByIdList(List<Long> bookIdList) {
        return bookIdList
                .stream().filter(id -> books.containsKey(id))
                .map(id -> books.get(id)).toList();
    }
}
