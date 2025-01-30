package com.study.bookcafe.query.borrow;

import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.query.book.BookView;
import com.study.bookcafe.query.member.MemberView;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class BorrowDetails {
    private long id;                        // 대출 ID
    private MemberView member;              // 회원
    private BookView book;                  // 도서
    private LocalDateTime time;             // 대출 시간
    private BorrowPeriod borrowPeriod;      // 대출 기간
}
