package com.study.bookcafe.application.command.member;

import com.study.bookcafe.domain.member.Member;

public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 반납
//    void returnBook(long memberId, long bookId);
}
