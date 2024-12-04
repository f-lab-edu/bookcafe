package com.study.bookcafe.entity;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@Getter
public class BorrowEntity {
    private long id;                        // 대출 ID
    private MemberEntity member;            // 회원
    private BookEntity book;                // 도서
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜
}
