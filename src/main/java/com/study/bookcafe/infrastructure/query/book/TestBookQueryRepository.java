package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.query.book.BookQueryRepository;
import com.study.bookcafe.domain.query.book.BookView;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class TestBookQueryRepository implements BookQueryRepository {

    private final BookMapper bookMapper;

    public TestBookQueryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public BookView findById(long bookId) {
        return TestBookQueryStorage.bookViews.get(bookId);
    }

    @Override
    public List<BookView> findByIds(Collection<Long> bookIds) {
        return bookIds.stream()
                .filter(id -> TestBookQueryStorage.bookViews.containsKey(id))
                .map(id -> TestBookQueryStorage.bookViews.get(id)).toList();
    }
}
