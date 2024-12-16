package com.study.bookcafe.repository;

import com.study.bookcafe.domain.Book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {
    Book findById(long bookId);
    List<Book> findByIds(Collection<Long> bookIds);
}
