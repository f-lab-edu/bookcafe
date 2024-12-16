package com.study.bookcafe.domain;

import lombok.Getter;

public enum Level {

    LIBRARIAN(2, 10,null, 2),          // 사서 회원
    WORM(1, 5,null, 1),                // 책벌레 회원
    BASIC(0, 3, WORM, 1);                    // 일반 회원

    private final int value;                      // 등급 값
    private final int maximumBorrowCount;         // 등급 별 최대 대출 권수
    private final Level next;                     // 다음 등급
    @Getter
    private final int borrowPeriod;

    Level(int value, int maximumBorrowCount, Level next, int borrowPeriod) {
        this.value = value;
        this.maximumBorrowCount = maximumBorrowCount;
        this.next = next;
        this.borrowPeriod = borrowPeriod;
    }

    /**
     * 회원의 대출 가능 권수를 알려준다.
     *
     * @param borrowCount (현재 회원의 현재대출권수)
     * @return 회원의 최대 대출 권수 - 회원의 현재 대출 권수
     */
    public boolean isBookBorrowCountLeft(int borrowCount) {
        return this.maximumBorrowCount - borrowCount > 0;
    }

}
