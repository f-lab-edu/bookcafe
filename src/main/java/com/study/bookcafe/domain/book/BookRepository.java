package com.study.bookcafe.domain.book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {
    Book findById(long bookId);
    List<Book> findByIds(Collection<Long> bookIds);
}
