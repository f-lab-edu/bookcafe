package com.study.bookcafe.infrastructure.command.book;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.book.BookInventoryRepository;
import com.study.bookcafe.infrastructure.query.book.TestBookQueryStorage;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TestBookInventoryRepository implements BookInventoryRepository {

    private final BookMapper bookMapper;

    public TestBookInventoryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Optional<BookInventory> findById(long id) {
        return Optional.ofNullable(TestBookQueryStorage.bookInventories.get(id));
    }

    @Override
    public Optional<BookInventory> findByBookId(long bookId) {
        return Optional.ofNullable(TestBookQueryStorage.bookInventories2.get(bookId));
    }

}
