package com.study.bookcafe.service;

import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.dto.BorrowDTO;
import com.study.bookcafe.dto.MemberDTO;

public interface BorrowService {
    // 대출 생성
    BorrowDTO createBorrow(MemberDTO member, BookDTO book);

    // 대출 성공 확인
    boolean successBorrow(BorrowDTO borrow);
}
