package com.study.bookcafe.infrastructure.query.book;

import com.study.bookcafe.domain.book.Inventory;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class BookEntity {
    private long id;                        // 도서 번호
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
    private Inventory inventory;            // 도서 상태 정보 (재고, 대출, 예약)
}
