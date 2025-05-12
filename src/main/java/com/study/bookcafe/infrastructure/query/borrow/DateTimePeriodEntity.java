package com.study.bookcafe.infrastructure.query.borrow;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DateTimePeriodEntity {
    @Column(name = "\"from\"")
    LocalDateTime from;
    @Column(name = "\"to\"")
    LocalDateTime to;
}
