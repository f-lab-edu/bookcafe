package com.study.bookcafe.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class BorrowDTO {
    private long borrowId;                  // 대출 ID
    private long memberId;                  // 회원 ID
    private long bookId;                    // 도서 ID
    private long ISBN;                      // 국제표준도서번호

    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜

    public BorrowDTO(long memberId, long bookId, long ISBN) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.ISBN = ISBN;
        this.borrowDate = Timestamp.valueOf(LocalDateTime.now());
        this.returnDate = Timestamp.valueOf(LocalDateTime.now().plusWeeks(1));
    }
}
