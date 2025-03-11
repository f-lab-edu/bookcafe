package com.study.bookcafe.query.book;

import java.util.Optional;

public interface BookInventoryQueryRepository {

    Optional<BookInventoryView> findById(long id);
    Optional<BookInventoryView> findByBookId(long bookId);

}
