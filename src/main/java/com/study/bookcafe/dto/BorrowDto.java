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
    private MemberDto memberDTO;            // 회원
    private BookDto bookDTO;                // 도서
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜

    public BorrowDto(MemberDto memberDTO, BookDto bookDTO) {
        this.memberDTO = memberDTO;
        this.bookDTO = bookDTO;
        this.borrowDate = Timestamp.valueOf(LocalDateTime.now());
        this.returnDate = Timestamp.valueOf(LocalDateTime.now().plusWeeks(1));
    }
}
