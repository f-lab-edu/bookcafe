package com.study.bookcafe.vo;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.time.LocalDateTime;

@EqualsAndHashCode
public class Period {
    /*
        - 대출 일자가 반납 일자보다 더 이전인 것을 보장할 책임
        - 대출 기간(대출 일자 ~ 반납 일자)을 생성할 책임
        - 연장 여부에 따라 반납 일자가 변경
            - 기본: 1주, 연장 시: 1주 추가, 총 2주
     */

    private final LocalDateTime from;           // 대출 일자
    private final LocalDateTime to;             // 반납 일자

    public Period(@NonNull LocalDateTime from) {
        this.from = from;
        this.to = this.from.plusWeeks(1);
    }

    public Period(@NonNull LocalDateTime from, @NonNull LocalDateTime to) {
        if(from.isAfter(to)) throw new IllegalArgumentException("반납 일자는 대출 일자보다 이후여야 합니다.");

        this.from = from;
        this.to = to;
    }
}
