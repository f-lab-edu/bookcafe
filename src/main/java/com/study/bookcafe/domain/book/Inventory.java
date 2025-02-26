package com.study.bookcafe.domain.book;

import lombok.Getter;

@Getter
public class Inventory {
    private int stock;                      // 재고
    private int borrowedCount;              // 대출 중인 권수
    private int reservationCount;           // 예약 건수

    public Inventory(int stock, int borrowedCount, int reservationCount) {
        this.stock = stock;
        this.borrowedCount = borrowedCount;
        this.reservationCount = reservationCount;
    }

    public boolean isOnStock() {
        return stock - borrowedCount > 0;
    }

    public boolean haveReservation() {
        return reservationCount > 0;
    }

    public void increaseBorrowedCount() {
        this.borrowedCount++;
    }
}
