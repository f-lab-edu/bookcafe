package com.study.bookcafe.domain;

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
    private long id;                        // 대출 ID
    private Member member;                  // 회원
    private Book book;                      // 도서
    private Timestamp borrowDate;           // 대출 날짜
    private Timestamp returnDate;           // 반납 날짜

    public Borrow(Member member, Book book) {
        this.member = member;
        this.book = book;
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
