package com.study.bookcafe.infrastructure.query.borrow;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PriorityBorrowPeriodEntity {
    @Embedded
    DateTimePeriodEntity period;
}
