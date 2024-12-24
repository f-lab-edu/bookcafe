package com.study.bookcafe.application.book;

import com.study.bookcafe.domain.book.Book;

import java.util.Collection;
import java.util.List;

public interface BookService {
    // 도서 조회 (id)
    Book findById(long bookId);

    // 도서 목록 조회 (id list)
    List<Book> findByIds(Collection<Long> bookIds);
}
