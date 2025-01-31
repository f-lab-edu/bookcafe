package com.study.bookcafe.domain.book;

import lombok.Getter;

@Getter
public class Inventory {
    private int stock;                      // 재고
    private int borrowed;                   // 대출 중인 권수
    private int reservationCount;           // 예약 건수

    public Inventory(int stock, int borrowed, int reservationCount) {
        this.stock = stock;
        this.borrowed = borrowed;
        this.reservationCount = reservationCount;
    }

    public boolean isOnStock() {
        return stock - borrowed > 0;
    }

    public boolean haveReservation() {
        return reservationCount > 0;
    }
}
