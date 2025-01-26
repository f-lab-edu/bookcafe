package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private long id;                        // 대출 ID
    private Member member;                  // 회원
    private Book book;                      // 도서
    private LocalDateTime time;             // 대출 시간
    private Period period;                  // 대출 기간
    private int extendedCount;              // 대출 연장한 횟수

    public Borrow(@NonNull Member member, @NonNull Book book, @NonNull LocalDateTime from) {
        this.member = member;
        this.book = book;
        this.time = from;
        this.period = Period.of(from.toLocalDate(), member.getLevel());
    }

    /**
     * 대출이 성공했는지 확인한다.
     *
     * @param borrow 대출
     * @return 대출이 성공했는지 여부
     */
    public static boolean successBorrow(Borrow borrow) {
        return borrow != null;
    }

    private void extendPeriod(Period period) {
        this.period = period;
    }

    private void increaseExtendCount() {
        this.extendedCount++;
    }

    /**
     * 대출을 연장한다.
     */
    public void extend() {
        if (!canExtend()) return;

        Period extendedPeriod = this.getPeriod().extend(this.getMember().getLevel());

        extendPeriod(extendedPeriod);
        increaseExtendCount();
    }

    /**
     * 연장 가능한 횟수가 남아있는지 확인한다.
     * <p>
     * 대출 연장은 1회 1주일만 가능하다.
     *
     * @return 연장 가능한지 여부
     */
    public boolean haveExtendableCount() {
        return this.getMember().getLevel().haveExtendableCount(extendedCount);
    }

    public boolean haveReservation() {
        return this.getBook().haveReservation();
    }

    /**
     * 대출 연장이 가능한 날짜인지 확인한다.
     * <p>
     * 대출 연장은 대출 기간의 50%가 경과했을 때부터 가능 (대출하자마자 연장하는 것을 방지)
     * 일반 회원은 4일차부터, 책벌레 회원과 사서 회원은 8일차부터 연장이 가능하다.
     *
     * @return 대출 연장 가능한지 여부
     */
    public boolean isExtendableDate() {
        return this.getPeriod().isExtendable();
    }

    private boolean canExtend() {
        // 연장 가능한 횟수가 남아있지 않으므로 불가
        if (!haveExtendableCount()) return false;

        // 도서에 예약이 있으므로 불가
        if (haveReservation()) return false;

        // 대출 연장이 가능한 날짜가 아니므로 불가
        if (!isExtendableDate()) return false;

        return true;
    }
}
