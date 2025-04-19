package com.study.bookcafe.domain.member;

import com.study.bookcafe.domain.borrow.PriorityBorrowRight;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@EqualsAndHashCode
public class Member {
    private long id;                        // 회원 ID
    private String password;                // 회원 Password
    private String name;                    // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수
    private int reservationCount;           // 현재 예약 권수

    private LocalDateTime createDate;       // 회원 가입 일자
    private LocalDateTime updateDate;       // 회원 수정 일자

    @Builder.Default
    private Map<Long, PriorityBorrowRight> priorityBorrowRightsMap = new HashMap<>(); // 도서 별 우선대출권

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    public boolean isBorrowable() {
        return this.getLevel().isBorrowCountLeft(getBorrowCount());
    }

    public boolean isReservable() {
        return this.getLevel().isReservationCountLeft(getReservationCount());
    }

    public void increaseBorrowCount() {
        if (!this.isBorrowable()) throw new IllegalStateException("회원의 대출 가능 권수가 없습니다.");

        this.borrowCount++;
    }

    public void increaseReservationCount() {
        if (!this.isReservable()) throw new IllegalStateException("회원의 예약 가능 권수가 없습니다.");

        this.reservationCount++;
    }

    public void decreaseReservationCount() {
        if (!this.haveReservationCount()) throw new IllegalStateException("회원의 예약 건수가 없습니다.");

        this.reservationCount--;
    }

    public boolean haveReservationCount() {
        return getReservationCount() > 0;
    }

    public void grant(PriorityBorrowRight priorityBorrowRight) {
        priorityBorrowRightsMap.put(priorityBorrowRight.getBookId(), priorityBorrowRight);
    }

    public boolean validatePriorityBorrowForBook(long bookId, LocalDateTime now) {
        return priorityBorrowRightsMap.containsKey(bookId) && priorityBorrowRightsMap.get(bookId).validateExpirationDate(now);
    }


}
