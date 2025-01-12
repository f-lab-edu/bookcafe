package com.study.bookcafe.query.book;

import com.study.bookcafe.query.member.MemberView;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BooksReservationDetails {
    private long id;                // 예약 번호
    private MemberView member;      // 회원
    private LocalDateTime time;     // 예약 시간
}
