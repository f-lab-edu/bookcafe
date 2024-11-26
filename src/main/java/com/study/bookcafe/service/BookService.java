package com.study.bookcafe.service;

import com.study.bookcafe.dto.BookDTO;

public interface BookService {
    // 도서 조회 (id)
    BookDTO findById(long bookId);

    // 대출 상태 확인
    boolean canBorrow(BookDTO book);
}
