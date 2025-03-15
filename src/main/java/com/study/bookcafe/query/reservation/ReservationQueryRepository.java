package com.study.bookcafe.query.reservation;

import java.util.List;

public interface ReservationQueryRepository {
    List<ReservationView> findByMemberId(long memberId);
}
