package com.study.bookcafe.dto;

import java.sql.Date;

public class BookDTO {
    // 도서 한 권에 대한 정보
    private long bookId;                    // 도서 번호

    // 같은 도서가 여러 권일 때, 재고나 대출 권수를 상태로 저장해야할지? or 각 도서를 다른 레코드로 저장해야할지?

    // 같은 도서 여러 권을 ISBN으로 묶어 하나의 도서에 대한 정보
    private long ISBN;                      // 국제표준도서번호
    private String title;                   // 도서 명
    private String author;                  // 저자 명
    private String publisher;               // 출판사
    private Date publishDate;               // 출판일
    private double price;                   // 도서 가격

    private boolean isBorrow = true;        // 현재 대출 여부
    private int inventory;                  // 재고
    private int borrowed;                   // 대출 중인 권수
    private int reservationCount;           // 예약 수

    public BookDTO(long ISBN, String title, String author, String publisher, Date publishDate, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
    }

    public BookDTO(String title, int inventory, int borrowed, int reservationCount) {
        this.title = title;
        this.inventory = inventory;
        this.borrowed = borrowed;
        this.reservationCount = reservationCount;
    }

    public long getISBN() {
        return ISBN;
    }

    private int getBorrowed() {
        return borrowed;
    }

    public boolean canBorrow() {
        return isBorrow;
    }
}
