package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ReservationEntity {
    private long id;                // 예약 번호
    private MemberEntity member;    // 회원
    private BookEntity book;        // 도서
    private LocalDateTime time;     // 예약 시간
}
