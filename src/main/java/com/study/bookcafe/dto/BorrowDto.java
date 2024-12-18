package com.study.bookcafe.dto;

import com.study.bookcafe.vo.Period;
import lombok.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDto {
    private long id;                        // 대출 ID
    private MemberDto member;               // 회원
    private BookDto book;                   // 도서
    private LocalDateTime time;             // 대출 시간
    private Period period;                  // 대출 기간

    public BorrowDto(MemberDto member, BookDto book, LocalDateTime from) {
        this.member = member;
        this.book = book;
        this.time = from;
        this.period = Period.of(from.toLocalDate(), member.getLevel());
    }
}
