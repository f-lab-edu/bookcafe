package com.study.bookcafe.borrow.domain.book;

import java.util.Optional;

public interface BookInventoryRepository {
    Optional<BookInventory> findByBookId(long bookId);
}
