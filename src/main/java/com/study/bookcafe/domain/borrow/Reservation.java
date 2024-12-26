package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Reservation {
    private long id;                // 예약 번호
    private Member member;          // 회원
    private Book book;              // 도서
    private LocalDateTime time;     // 예약 시간

    // 예약 순서

}
