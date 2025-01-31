package com.study.bookcafe.interfaces.borrow;

import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.interfaces.member.MemberDto;
import com.study.bookcafe.interfaces.book.BookDto;
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
    private BorrowPeriod borrowPeriod;      // 대출 기간

    public BorrowDto(MemberDto member, BookDto book, LocalDateTime from) {
        this.member = member;
        this.book = book;
        this.time = from;
        this.borrowPeriod = BorrowPeriod.of(from.toLocalDate(), member.getLevel());
    }
}
