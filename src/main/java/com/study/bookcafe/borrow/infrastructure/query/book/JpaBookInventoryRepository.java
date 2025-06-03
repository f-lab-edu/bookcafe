package com.study.bookcafe.borrow.infrastructure.query.book;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.book.BookInventoryRepository;
import com.study.bookcafe.borrow.interfaces.book.BookMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("borrowContextBookInventoryRepository")
public class JpaBookInventoryRepository implements BookInventoryRepository {

    @PersistenceContext
    EntityManager em;

    private final BookMapper bookMapper;

    public JpaBookInventoryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<BookInventory> findByBookId(long bookId) {
        return Optional.ofNullable(em.find(BookInventoryEntity.class, bookId)).map(bookMapper::toBookInventory);
    }
}
