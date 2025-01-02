package com.study.bookcafe.application.member;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출
    List<Borrow> borrowBook(long memberId, Collection<Long> bookIds);

    // 도서 예약
    Reservation reserveBook(long memberId, long bookId);
}
