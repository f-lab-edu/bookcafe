package com.study.bookcafe.borrow.domain.borrow;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.member.Member;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class BorrowBusiness {
    private long id;                        // 대출 ID
    private Member member;                  // 회원
    private BookInventory book;             // 도서
    private LocalDateTime time;             // 대출 시간
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime returnTime;       // 반납 시간
    private BorrowPeriod borrowPeriod;      // 대출 기간
    private int extensionCount;             // 대출 연장한 횟수

    private final int MAXIMUM_EXTENSION_COUNT = 1;

    public static BorrowBusiness of(@NonNull final Member member, @NonNull final BookInventory book) {
        return new BorrowBusiness(member, book, LocalDateTime.now());
    }

    public static BorrowBusiness of(@NonNull final Member member, @NonNull final BookInventory book, @NonNull final LocalDateTime from) {
        return new BorrowBusiness(member, book, from);
    }

    private BorrowBusiness(@NonNull final Member member, @NonNull final BookInventory book, @NonNull final LocalDateTime from) {
        member.increaseBorrowCount();
        book.increaseBorrowedCount();

        this.member = member;
        this.book = book;
        this.time = from;
        this.borrowPeriod = BorrowPeriod.of(from.toLocalDate(), member.getLevel());
    }

    private void updateExtendedPeriod(@NonNull final BorrowPeriod borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    private void increaseExtendCount() {
        if (extensionCount >= MAXIMUM_EXTENSION_COUNT) throw new IllegalStateException("대출의 연장 가능한 횟수가 없습니다.");

        extensionCount++;
    }

    /**
     * 대출을 연장한다.
     */
    public void extendPeriod(@NonNull final LocalDate now) {
        if (!canExtend(now)) return;

        BorrowPeriod extendedPeriod = this.getBorrowPeriod().extend();

        updateExtendedPeriod(extendedPeriod);
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
        return member.getLevel().haveExtendableCount(extensionCount);
    }
//
    private boolean haveReservationForBook() {
        return book.haveReservedCount();
    }

    /**
     * 대출 연장이 가능한 날짜인지 확인한다.
     * <p>
     * 대출 연장은 대출 기간의 50%가 경과했을 때부터 가능 (대출하자마자 연장하는 것을 방지)
     * 일반 회원은 4일차부터, 책벌레 회원과 사서 회원은 8일차부터 연장이 가능하다.
     *
     * @return 대출 연장 가능한지 여부
     */
    public boolean isExtendableDate(@NonNull final LocalDate now) {
        return borrowPeriod.isExtendable(now);
    }

    private boolean canExtend(@NonNull final LocalDate now) {
        // 연장 가능한 횟수가 남아있지 않으므로 불가
        if (!haveExtendableCount()) throw new IllegalStateException("잔여 연장 횟수가 없습니다.");

        // 도서에 예약이 있으므로 불가
        if (haveReservationForBook()) throw new IllegalStateException("연장하려는 도서에 예약이 있습니다.");

        // 대출 연장이 가능한 날짜가 아니므로 불가
        if (!isExtendableDate(now)) throw new IllegalStateException("연장 가능한 날짜가 아닙니다.");

        return true;
    }

    public void terminate(@NonNull final LocalDateTime date) {
        setReturnTime(date);
        member.decreaseBorrowCount();
        book.decreaseBorrowedCount();
    }

    public void borrow() {

    }
}
