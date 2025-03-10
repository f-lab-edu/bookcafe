package com.study.bookcafe.domain.book;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {
    private final long id;                        // 도서 번호

    @NotNull(message = "도서 정보는 필수 값입니다.")
    private BookInfo info;
    @NotNull(message = "도서 재고는 필수 값입니다.")
    private BookInventory inventory;

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    public boolean isBorrowable() {
        return this.getInventory().isOnStock();
    }

    /**
     * 도서에 예약이 있는지 확인한다.
     *
     * @return 현재 도서에 대한 예약이 있는지 여부
     */
    public boolean haveReservation() {
        return this.getInventory().haveReservation();
    }

    public void increaseBorrowedCount() {
        this.getInventory().increaseBorrowedCount();
    }
    public void increaseReservedCount() {
        this.getInventory().increaseReservedCount();
    }
}
