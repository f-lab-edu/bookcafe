package com.study.bookcafe.domain.query.book;

import java.util.Collection;
import java.util.List;

public interface BookQueryRepository {

    BookView findById(long bookId);
    List<BookView> findByIds(Collection<Long> bookIds);

}
