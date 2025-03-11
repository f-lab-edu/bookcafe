package com.study.bookcafe.interfaces.borrow;

import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.interfaces.book.BookInventoryDto;
import com.study.bookcafe.interfaces.member.MemberDto;
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
    private BookInventoryDto book;          // 도서
    private LocalDateTime time;             // 대출 시간
    private BorrowPeriod borrowPeriod;      // 대출 기간
    private int extensionCount;             // 대출 연장한 횟수

    public BorrowDto(MemberDto member, BookInventoryDto book, LocalDateTime from) {
        this.member = member;
        this.book = book;
        this.time = from;
        this.borrowPeriod = BorrowPeriod.of(from.toLocalDate(), member.getLevel());
    }
}
