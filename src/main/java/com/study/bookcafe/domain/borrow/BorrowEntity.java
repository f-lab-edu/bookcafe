package com.study.bookcafe.domain.borrow;

import com.study.bookcafe.domain.book.BookEntity;
import com.study.bookcafe.domain.member.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Builder
@Getter
public class BorrowEntity {
    private long id;                        // 대출 ID
    @NonNull
    private MemberEntity member;            // 회원
    @NonNull
    private BookEntity book;                // 도서
    @NonNull
    private LocalDateTime time;             // 대출 시간
    private Period period;                  // 대출 기간
}
