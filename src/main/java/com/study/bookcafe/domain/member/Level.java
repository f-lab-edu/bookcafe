package com.study.bookcafe.domain.member;

import lombok.Getter;

public enum Level {

    LIBRARIAN(2, 10,null, 1, 1),          // 사서 회원
    WORM(1, 5,null, 1, 1),                // 책벌레 회원
    BASIC(0, 3, WORM, 1, 1);                    // 일반 회원

    private final int value;                      // 등급 값
    private final int maximumBorrowCount;         // 최대 대출 권수
    private final Level next;                     // 다음 등급
    private final int maximumExtendCount;         // 최대 대출 연장 횟수
    @Getter
    private final int borrowPeriod;         // 대출 연장 기간

    Level(int value, int maximumBorrowCount, Level next, int maximumExtendCount, int borrowPeriod) {
        this.value = value;
        this.maximumBorrowCount = maximumBorrowCount;
        this.next = next;
        this.maximumExtendCount = maximumExtendCount;
        this.borrowPeriod = borrowPeriod;
    }

    /**
     * 회원의 대출 가능 권수를 확인한다.
     *
     * @param borrowCount (현재 회원의 현재대출권수)
     * @return 회원의 최대 대출 권수 - 회원의 현재 대출 권수
     */
    public boolean isBookBorrowCountLeft(int borrowCount) {
        return this.maximumBorrowCount - borrowCount > 0;
    }

    /**
     * 회원의 대출 연장 가능 횟수를 확인한다.
     *
     * @param extendedCount 연장한 횟수
     * @return 회원의 최대 대출 연장 횟수 - 회원의 연장한 횟수
     */
    public boolean haveExtendableCount(int extendedCount) {
        return this.maximumExtendCount - extendedCount > 0;
    }

}
