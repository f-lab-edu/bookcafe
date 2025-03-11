package com.study.bookcafe.domain.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookInventory {
    private long id;                        // 인벤토리 ID
    private long bookId;                    // 도서 ID
    @NotNull(message = "도서는 필수 값입니다.")
    private Book book;                      // 도서

    @PositiveOrZero(message = "재고는 0 이상이어야 합니다.")
    private int stock;                      // 재고
    @PositiveOrZero(message = "대출 건수는 0 이상이어야 합니다.")
    private int borrowedCount;              // 대출 건수
    @PositiveOrZero(message = "예약 건수는 0 이상이어야 합니다.")
    private int reservedCount;              // 예약 건수

    private final int MAXIMUM_RESERVATION_COUNT = 5;

    /**
     * 도서가 대출 가능한 상태인지 확인한다.
     *
     * @return 현재 도서의 대출 가능한 재고가 있는지 여부
     */
    public boolean isBorrowable() {
        return this.isOnStock();
    }

    private boolean isOnStock() {
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
