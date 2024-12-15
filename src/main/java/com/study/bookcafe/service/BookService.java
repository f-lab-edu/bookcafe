package com.study.bookcafe.service;

import com.study.bookcafe.domain.Book;

import java.util.Collection;
import java.util.List;

public interface BookService {
    // 도서 조회 (id)
    Book findById(long bookId);

    // 도서 목록 조회 (id list)
    List<Book> findByIdList(Collection<Long> bookIds);
}
