package com.study.bookcafe.service;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.dto.BorrowDto;
import com.study.bookcafe.entity.BorrowEntity;

public interface BorrowService {
    // 대출 생성
//    BorrowDTO createBorrow(MemberDTO member, BookDTO book);

    // 대출 저장
    Borrow save(Borrow borrow);
}
