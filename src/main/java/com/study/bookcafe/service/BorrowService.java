package com.study.bookcafe.service;

import com.study.bookcafe.common.ApiResult;

public interface BorrowService {
    ApiResult borrowBook(long memberId, long bookId);
}
