package com.study.bookcafe.domain;

import com.study.bookcafe.vo.Period;
import lombok.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private long id;                        // 대출 ID
    private Member member;                  // 회원
    private Book book;                      // 도서
    private LocalDateTime time;             // 대출 시간
    private Period period;                  // 대출 기간

    public Borrow(@NonNull Member member, @NonNull Book book, @NonNull LocalDateTime from) {
        this.member = member;
        this.book = book;
        this.time = from;
        this.period = Period.of(from.toLocalDate(), member.getLevel());
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
