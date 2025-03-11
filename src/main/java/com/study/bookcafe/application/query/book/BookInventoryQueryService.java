package com.study.bookcafe.application.query.book;

import com.study.bookcafe.query.book.BookInventoryView;

public interface BookInventoryQueryService {

    BookInventoryView findById(long id);
    BookInventoryView findByBookId(long bookId);

}
