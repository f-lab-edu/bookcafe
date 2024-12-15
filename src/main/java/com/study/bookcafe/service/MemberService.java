package com.study.bookcafe.service;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출
    List<Borrow> borrowBook(long memberId, Collection<Long> bookIds);
}
