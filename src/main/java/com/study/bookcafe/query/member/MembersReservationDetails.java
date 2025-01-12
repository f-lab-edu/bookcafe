package com.study.bookcafe.query.member;

import com.study.bookcafe.query.book.BookView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MembersReservationDetails {
    private long id;                // 예약 번호
    private BookView book;          // 도서
    private int order;              // 예약 순서
    private LocalDateTime time;     // 예약 시간
}
