package com.study.bookcafe.application.query.book;

import com.study.bookcafe.query.book.BookView;

import java.util.Collection;
import java.util.List;

public interface BookQueryService {

    // 도서 조회 (id)
    BookView findById(long bookId);

    // 도서 목록 조회 (id list)
    List<BookView> findByIds(Collection<Long> bookIds);
}
