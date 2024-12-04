package com.study.bookcafe.dao;

import com.study.bookcafe.entity.BookEntity;

import java.util.List;

public interface BookRepository {
    BookEntity findById(long bookId);
    List<BookEntity> findByIdList(List<Long> bookIdList);
}
