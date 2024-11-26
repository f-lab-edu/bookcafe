package com.study.bookcafe.dto;

import com.study.bookcafe.entity.Inventory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Builder
@Getter
@Setter
public class BookDTO {
    /*
        1. 재고 관리
        2. 대출 권수 관리
        3. 대출 내역 관리
     */

    private long bookId;                    // 도서 번호
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
    private Inventory inventory;            // 도서 상태 정보 (재고, 대출, 예약)

}

