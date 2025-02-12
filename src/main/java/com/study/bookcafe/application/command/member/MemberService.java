package com.study.bookcafe.application.command.member;

import com.study.bookcafe.domain.member.Member;
import java.util.Collection;

public interface MemberService {

    // 회원 조회 (id)
    Member findById(long memberId);

    // 도서 대출
    void borrowBook(long memberId, Collection<Long> bookIds);

    // 도서 대출 연장
    void extendBook(long memberId, long bookId);

    // 도서 예약
    void reserveBook(long memberId, long bookId);

    // 도서 예약 취소
    void cancelReservation(long reservationId);

    // 도서 반납
    void returnBook(long memberId, long bookId);
}
