package com.study.bookcafe.domain.command.book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    Book findById(long bookId);
    List<Book> findByIds(Collection<Long> bookIds);

}
