package com.study.bookcafe.interfaces.member;

import com.study.bookcafe.domain.command.book.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MembersReservationDetails {
    private long id;                // 예약 번호
    private Book book;              // 도서
    private int order;              // 예약 순서
    private LocalDateTime time;     // 예약 시간
}
