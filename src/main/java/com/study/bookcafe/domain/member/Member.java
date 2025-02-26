package com.study.bookcafe.domain.member;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.Return;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class Member {
    private long id;                        // 회원 ID
    private String password;                // 회원 Password
    private String name;                    // 회원 이름
    private Level level;                    // 회원 등급
    private int borrowCount;                // 현재 대출 권수

    private LocalDateTime createDate;       // 회원 가입 일자
    private LocalDateTime updateDate;       // 회원 수정 일자

    /**
     * 회원이 대출 가능한 상태인지 알려준다.
     *
     * @return 현재 회원의 대출 가능 권수가 남았는지 여부
     */
    public boolean canBorrow() {
        return this.getLevel().isBookBorrowCountLeft(getBorrowCount());
    }

    public void increaseBorrowCount() {
        this.borrowCount++;
    }

    /**
     * 회원이 도서 대출을 예약한다.
     *
     * @param book 도서
     * @return 예약
     */
    public Reservation reserveBook(Book book) {
        return Reservation.builder()
                .memberId(this.getId())
                .bookId(book.getId())
                .time(LocalDateTime.now())
                .build();
    }

    public Return returnBook(final Book book) {
        return Return.builder()
                .member(this)
                .book(book)
                .date(LocalDateTime.now())
                .build();
    }

}
