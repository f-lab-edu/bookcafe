package com.study.bookcafe.service;

import com.study.bookcafe.domain.Book;

public interface BookService {
    // 도서 조회 (id)
    Book findById(long bookId);
}