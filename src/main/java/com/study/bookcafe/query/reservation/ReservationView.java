package com.study.bookcafe.query.reservation;

import com.study.bookcafe.query.book.BookInventoryView;
import com.study.bookcafe.query.member.MemberView;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class ReservationView {
    private long id;                    // 예약 번호
    private MemberView member;          // 회원
    private BookInventoryView book;     // 도서
    private LocalDateTime time;         // 예약 시간
    private int order;                  // 예약 순서
}
