package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.query.book.BookInventoryQueryRepository;
import com.study.bookcafe.query.book.BookInventoryView;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class TestBookInventoryQueryRepository implements BookInventoryQueryRepository {

    private final BookMapper bookMapper;

    public TestBookInventoryQueryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Optional<BookInventoryView> findById(long id) {
        return Optional.ofNullable(TestBookQueryStorage.bookInventoryViews.get(id));
    }

    @Override
    public Optional<BookInventoryView> findByBookId(long bookId) {
        return Optional.ofNullable(TestBookQueryStorage.bookInventoryViews2.get(bookId));
    }
}
