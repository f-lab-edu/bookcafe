package com.study.bookcafe.domain.borrow;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Reservation {
    private long id;                // 예약 번호
    private long memberId;          // 회원 ID
    private long bookId;            // 도서 ID
    private LocalDateTime time;     // 예약 시간
}
