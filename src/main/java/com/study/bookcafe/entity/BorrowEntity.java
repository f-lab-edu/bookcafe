package com.study.bookcafe.entity;

import com.study.bookcafe.vo.Period;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class BorrowEntity {
    private long id;                        // 대출 ID
    @NonNull
    private MemberEntity member;            // 회원
    @NonNull
    private BookEntity book;                // 도서
    private Period period;                  // 대출 기간
}
