package com.study.bookcafe.entity;

import lombok.Getter;

@Getter
public class Inventory {
    private int stock;                      // 재고
    private int borrowed;                   // 대출 중인 권수
    private int reservationCount;           // 예약 수

    public Inventory(int stock) {
        this.stock = stock;
        this.borrowed = 0;
        this.reservationCount = 0;
    }

    public boolean isOnStock() {
        return stock - borrowed > 0;
    }
}
