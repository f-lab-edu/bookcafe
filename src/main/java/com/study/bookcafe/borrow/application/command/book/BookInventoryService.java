package com.study.bookcafe.borrow.application.command.book;

import com.study.bookcafe.borrow.domain.book.BookInventory;

import java.util.Optional;

public interface BookInventoryService {
    Optional<BookInventory> findByBookId(long bookId);
}
