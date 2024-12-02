package com.study.bookcafe.service;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출
    Borrow borrowBook(long memberId, long bookId);
}
