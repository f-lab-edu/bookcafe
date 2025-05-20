package com.study.bookcafe.borrow.domain.member;

import lombok.Getter;

public enum Level {

    LIBRARIAN(2, 10, 1, 5, 2, 1),          // 사서 회원
    WORM(1, 5,1, 5,2, 1),                // 책벌레 회원
    BASIC(0, 3, 1, 5,1, 1);                    // 일반 회원

    private final int value;                      // 등급 값
    private final int maximumBorrowCount;         // 최대 대출 권수
    private final int maximumExtendCount;         // 최대 대출 연장 횟수
    private final int maximumReservationCount;    // 최대 예약 권수

    @Getter
    private final int borrowPeriod;               // 대출 기간 (week)
    @Getter
    private final int extendPeriod;               // 연장 기간 (week)

    Level(int value, int maximumBorrowCount, int maximumExtendCount, int maximumReservationCount, int borrowPeriod, int extendPeriod) {
        this.value = value;
        this.maximumBorrowCount = maximumBorrowCount;
        this.maximumExtendCount = maximumExtendCount;
        this.maximumReservationCount = maximumReservationCount;
        this.borrowPeriod = borrowPeriod;
        this.extendPeriod = extendPeriod;
    }

    /**
     * 회원의 대출 가능 권수를 확인한다.
     *
     * @param borrowCount (현재 회원의 현재대출권수)
     * @return 회원의 최대 대출 권수 - 회원의 현재 대출 권수
     */
    public boolean isBorrowCountLeft(final int borrowCount) {
        if (borrowCount < 0) throw new IllegalArgumentException("대출 권수는 0보다 작을 수 없습니다.");

        return maximumBorrowCount - borrowCount > 0;
    }

    public boolean isReservationCountLeft(final int reservationCount) {
        if (reservationCount < 0) throw new IllegalArgumentException("예약 권수는 0보다 작을 수 없습니다.");

        return maximumReservationCount - reservationCount > 0;
    }

    /**
     * 회원의 대출 연장 가능 횟수를 확인한다.
     *
     * @param extendedCount 연장한 횟수
     * @return 회원의 최대 대출 연장 횟수 - 회원의 연장한 횟수
     */
    public boolean haveExtendableCount(final int extendedCount) {
        return maximumExtendCount - extendedCount > 0;
    }

}
