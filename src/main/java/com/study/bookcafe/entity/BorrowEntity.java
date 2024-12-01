package com.study.bookcafe.entity;

import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@Getter
public class BorrowEntity {
    private Member member;                  // 회원
    private Book book;                      // 도서
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜
}
