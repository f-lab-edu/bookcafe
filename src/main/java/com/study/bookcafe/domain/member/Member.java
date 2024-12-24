package com.study.bookcafe.domain.member;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Borrow;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<Borrow> borrowBook(List<Book> books) {
        List<Borrow> borrows = new ArrayList<>();

        // 회원이 대출 가능한 상태 확인
        if(!this.canBorrow()) {
            return borrows;
        }

        // 대출 가능한 도서만 목록에 담기
        return books.stream()
                .filter(Book::canBorrow)
                .map(book -> new Borrow(this, book, LocalDateTime.now()))
                .toList();
    }
}
