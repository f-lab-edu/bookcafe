package com.study.bookcafe.interfaces.book;

import com.study.bookcafe.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BooksReservationDetails {
    private long id;                // 예약 번호
    private Member member;          // 회원
    private LocalDateTime time;     // 예약 시간
}
