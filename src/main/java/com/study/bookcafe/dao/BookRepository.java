package com.study.bookcafe.dao;

import com.study.bookcafe.domain.Book;

import java.util.List;

public interface BookRepository {
    Book findById(long bookId);
    List<Book> findByIdList(List<Long> bookIdList);
}
