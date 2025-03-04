package com.study.bookcafe.domain.reservation;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Reservation {
    private long id;                // 예약 번호
    private Member member;          // 회원
    private Book book;              // 도서
    private LocalDateTime time;     // 예약 시간

    public static Reservation of(final Member member, final Book book) {
        if (book.isBorrowable()) {
            if (member.isBorrowable()) throw new IllegalStateException("해당 도서는 대출 가능한 상태입니다.");
            // 도서가 대출 가능한 상태일 경우, 예약은 불가능
            else throw new IllegalStateException("해당 도서는 대출 가능한 상태이지만 회원님은 대출 가능한 상태가 아닙니다.");
        }

        member.increaseReservationCount();
        book.increaseReservationCount();

        return Reservation.builder()
                .member(member)
                .book(book)
                .time(LocalDateTime.now())
                .build();
    }
}
