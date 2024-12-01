package com.study.bookcafe.domain;

import com.study.bookcafe.entity.BorrowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private Member member;                  // 회원
    private Book book;                      // 도서
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜

    public Borrow(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public BorrowEntity toEntity() {
        return BorrowEntity.builder()
                .member(this.getMember())
                .book(this.getBook())
                .borrowDate(this.getBorrowDate())
                .returnDate(this.getReturnDate())
                .build();
    }

    public static Borrow from(BorrowEntity entity) {
        return Borrow.builder()
                .member(entity.getMember())
                .book(entity.getBook())
                .borrowDate(entity.getBorrowDate())
                .returnDate(entity.getReturnDate())
                .build();
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
}
