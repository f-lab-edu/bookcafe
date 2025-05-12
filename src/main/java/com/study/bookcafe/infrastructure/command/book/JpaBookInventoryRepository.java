package com.study.bookcafe.infrastructure.command.book;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.book.BookInventoryRepository;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.interfaces.book.BookMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("jpa")
public class JpaBookInventoryRepository implements BookInventoryRepository {

    private final BookMapper bookMapper;

    @PersistenceContext
    private EntityManager em;

    public JpaBookInventoryRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<BookInventory> findById(long id) {
        return Optional.ofNullable(em.find(BookInventoryEntity.class, id))
                .map(bookMapper::toBookInventory);
    }

    @Override
    public Optional<BookInventory> findByBookId(long bookId) {
        return em
                .createQuery("SELECT b FROM book b WHERE b.bookId = :bookId", BookInventoryEntity.class)
                .setParameter("bookId", bookId)
                .getResultStream()
                .findAny()
                .map(bookMapper::toBookInventory);
    }

    @Override
    public void update(BookInventory bookInventory) {
        em.merge(bookMapper.toBookInventoryEntity(bookInventory));
    }
}
