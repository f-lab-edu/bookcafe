package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BookEntity;

public interface BookRepository {
    BookEntity findById(long bookId);
}
