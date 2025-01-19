package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import lombok.*;
import java.time.LocalDate;
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
     * 연장 가능한 횟수가 남아있는지 확인한다.
     * <p>
     * 대출 연장은 1회 1주일만 가능하다.
     *
     * @return 연장 가능한지 여부
     */
    public boolean haveExtendableCount() {
        return this.getMember().getLevel().haveExtendableCount(extendedCount);
    }

    /**
     * 대출을 연장한다.
     */
    public void extend() {
        // 연장 가능한 횟수가 남아있지 않으므로 불가
        if (!haveExtendableCount()) return;

        // 도서에 예약이 있으므로 불가
        if (this.getBook().haveReservation()) return;

        // 대출 연장이 가능한 날짜가 아니므로 불가
        if (!isPassHalfofPeriod()) return;

        LocalDate from = this.getPeriod().getFrom();
        LocalDate extendedTo = this.getPeriod().getTo().plusWeeks(1);
        Period extendedPeriod = new Period(from, extendedTo);

        extendPeriod(extendedPeriod);
        increaseExtendCount();
    }

    /**
     * 대출 연장이 가능한 날짜인지 확인한다.
     * <p>
     * 대출 연장은 대출 기간의 50%가 경과했을 때부터 가능 (대출하자마자 연장하는 것을 방지)
     * 일반 회원은 4일차부터, 책벌레 회원과 사서 회원은 8일차부터 연장이 가능하다.
     *
     * @return 대출 연장 가능한지 여부
     */
    public boolean isPassHalfofPeriod() {
        LocalDate now = LocalDate.now();

        int halfPeriod = this.getMember().getLevel().getBorrowPeriod() * 7 / 2;
        LocalDate targetDate = this.getPeriod().getFrom().plusDays(halfPeriod);

        return now.isEqual(targetDate) || now.isAfter(targetDate);
    }
}