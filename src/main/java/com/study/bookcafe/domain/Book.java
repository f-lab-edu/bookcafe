package com.study.bookcafe.domain;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class Book {
    private long id;                        // 도서 번호
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격
    private Inventory inventory;            // 도서 상태 정보 (재고, 대출, 예약)

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    public boolean canBorrow() {
        return this.getInventory() != null && this.getInventory().isOnStock();
    }
}
