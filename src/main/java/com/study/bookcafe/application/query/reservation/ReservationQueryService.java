package com.study.bookcafe.application.query.reservation;

import com.study.bookcafe.query.reservation.ReservationView;
import java.util.List;

public interface ReservationQueryService {
    List<ReservationView> findMembersReservationDetails(long memberId);
}
