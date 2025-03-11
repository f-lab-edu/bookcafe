package com.study.bookcafe.domain.book;

import java.util.Optional;

public interface BookInventoryRepository {

    Optional<BookInventory> findById(long id);
    Optional<BookInventory> findByBookId(long bookId);

}
