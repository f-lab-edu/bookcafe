package com.study.bookcafe.domain.query.borrow;

import com.study.bookcafe.domain.command.borrow.Period;
import com.study.bookcafe.domain.query.book.BookView;
import com.study.bookcafe.domain.query.member.MemberView;
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
    private Period period;                  // 대출 기간
}
