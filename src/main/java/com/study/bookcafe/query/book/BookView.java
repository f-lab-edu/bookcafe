package com.study.bookcafe.query.book;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class BookView {
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
}
