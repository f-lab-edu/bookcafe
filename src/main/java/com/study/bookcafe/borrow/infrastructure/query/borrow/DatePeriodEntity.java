package com.study.bookcafe.borrow.infrastructure.query.borrow;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DatePeriodEntity {
    @Column(name = "\"from\"")
    LocalDate from;           // 시작 일자
    @Column(name = "\"to\"")
    LocalDate to;             // 종료 일자
}
