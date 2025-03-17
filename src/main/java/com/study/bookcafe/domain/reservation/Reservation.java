package com.study.bookcafe.domain.reservation;

import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Reservation {
    private long id;                // 예약 번호
    private Member member;          // 회원
    private BookInventory book;     // 도서
    private LocalDateTime time;     // 예약 시간

    public static Reservation of(final Member member, final BookInventory bookInventory) {
        return new Reservation(member, bookInventory);
    }

    public Reservation(final Member member, final BookInventory bookInventory) {
        if (bookInventory.isBorrowable()) {
            if (member.isBorrowable()) throw new IllegalStateException("해당 도서는 대출 가능한 상태입니다.");
            // 도서가 대출 가능한 상태일 경우, 예약은 불가능
            else throw new IllegalStateException("해당 도서는 대출 가능한 상태이지만 회원님은 대출 가능한 상태가 아닙니다.");
        }

        member.increaseReservationCount();
        bookInventory.increaseReservedCount();

        this.member = member;
        this.book = bookInventory;
        this.time = LocalDateTime.now();
    }
}
