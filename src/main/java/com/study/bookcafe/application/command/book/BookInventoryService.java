package com.study.bookcafe.application.command.book;

import com.study.bookcafe.domain.book.BookInventory;

public interface BookInventoryService {

    // 도서 조회 (id)
    BookInventory findById(long bookId);
    BookInventory findByBookId(long bookId);

}
