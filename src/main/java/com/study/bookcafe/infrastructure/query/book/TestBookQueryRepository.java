package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.command.book.Inventory;
import com.study.bookcafe.domain.query.book.BookQueryRepository;
import com.study.bookcafe.domain.query.book.BookView;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestBookQueryRepository implements BookQueryRepository {

    private final BookMapper bookMapper;

    public TestBookQueryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public static Map<Long, BookView> books = new HashMap<>(){{
        put(1L, BookView.builder().id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build());
        put(2L, BookView.builder().id(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
                .price(13000).inventory(new Inventory(0)).build());
    }};

    public BookView findById(long bookId) {
        return books.get(bookId);
    }

    @Override
    public List<BookView> findByIds(Collection<Long> bookIds) {
        return bookIds.stream()
                .filter(id -> books.containsKey(id))
                .map(id -> books.get(id)).toList();
    }
}
