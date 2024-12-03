package com.study.bookcafe.dto;

import lombok.*;

import java.sql.Timestamp;
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
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜

    public BorrowDto(MemberDto member, BookDto book) {
        this.member = member;
        this.book = book;
        this.borrowDate = Timestamp.valueOf(LocalDateTime.now());
        this.returnDate = Timestamp.valueOf(LocalDateTime.now().plusWeeks(1));
    }
}
