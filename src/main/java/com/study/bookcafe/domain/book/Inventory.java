package com.study.bookcafe.domain.book;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class Inventory {
    @PositiveOrZero(message = "재고는 0 이상이어야 합니다.")
    private int stock;                      // 재고
    @PositiveOrZero(message = "대출 건수는 0 이상이어야 합니다.")
    private int borrowedCount;              // 대출 건수
    @PositiveOrZero(message = "예약 건수는 0 이상이어야 합니다.")
    private int reservedCount;              // 예약 건수

    private final int MAXIMUM_RESERVATION_COUNT = 5;

    public Inventory(int stock) {
        this.stock = stock;
    }

    public Inventory(int stock, int borrowedCount, int reservedCount) {
        this.stock = stock;
        this.borrowedCount = borrowedCount;
        this.reservedCount = reservedCount;
    }

    public boolean isOnStock() {
        return stock - borrowedCount > 0;
    }

    public boolean haveReservation() {
        return reservedCount > 0;
    }

    public void increaseBorrowedCount() {
        if (!isOnStock()) throw new IllegalStateException("해당 도서는 이미 모두 대출되었습니다.");

        this.borrowedCount++;
    }
    public void increaseReservedCount() {
        if (MAXIMUM_RESERVATION_COUNT - reservedCount <= 0) throw new IllegalStateException("해당 도서에 대한 예약이 모두 찼습니다.");

        this.reservedCount++;
    }
}
