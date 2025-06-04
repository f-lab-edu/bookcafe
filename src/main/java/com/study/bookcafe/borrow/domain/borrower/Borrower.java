package com.study.bookcafe.borrow.domain.borrower;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Borrower {
    private long id;                        // 회원 ID
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    public void assertBorrowable() {
        if (!isBorrowable()) throw new IllegalStateException("회원의 대출 가능 권수가 없습니다.");
    }

    private boolean isBorrowable() {
        return level.isBorrowCountLeft(borrowCount);
    }

    public boolean haveBorrowCount() {
        return borrowCount > 0;
    }
}
