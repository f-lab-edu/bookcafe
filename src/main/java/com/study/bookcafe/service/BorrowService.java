package com.study.bookcafe.service;

import com.study.bookcafe.domain.Borrow;

public interface BorrowService {
    // 대출 저장
    Borrow save(Borrow borrow);
}
