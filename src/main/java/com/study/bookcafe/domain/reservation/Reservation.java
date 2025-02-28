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
        // 대출 가능한 상태 -> 대출 로직으로 안내
        if (member.canBorrow() && book.isBorrowable()) throw new IllegalStateException("해당 도서는 대출 가능한 상태입니다.");

        // 도서는 대출 가능한 상태지만 회원은 대출 불가능한 상태 ->  대출 가능한 상태라고 안내
        if (book.isBorrowable()) throw new IllegalStateException("해당 도서는 대출 가능한 상태이지만 회원님은 대출 가능한 상태가 아닙니다.");

        book.increaseReservationCount();

        return Reservation.builder()
                .member(member)
                .book(book)
                .time(LocalDateTime.now())
                .build();
    }
}
