package com.study.bookcafe.borrow.domain.borrower;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.borrow.BorrowBusiness;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Member implements Borrower {
    private long id;                        // 회원 ID
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    @Override
    public boolean isBorrowable() {
        return level.isBorrowCountLeft(borrowCount);
    }

    @Override
    public void increaseBorrowCount() {
        if (!isBorrowable()) throw new IllegalStateException("회원의 대출 가능 권수가 없습니다.");

        borrowCount++;
    }

    @Override
    public void decreaseBorrowCount() {
        if (!haveBorrowCount()) throw new IllegalStateException("회원의 대출 건수가 없습니다.");

        borrowCount--;
    }

    @Override
    public boolean haveBorrowCount() {
        return borrowCount > 0;
    }

    public BorrowBusiness borrow(BookInventory book) {


        return BorrowBusiness.of(this, book);
    }
}
