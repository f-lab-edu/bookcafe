package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.query.reservation.ReservationQueryRepository;
import com.study.bookcafe.query.reservation.ReservationView;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TestReservationQueryRepository implements ReservationQueryRepository {
    @Override
    public List<ReservationView> findByMemberId(long memberId) {
        return TestReservationQueryStorage.membersReservationViews.get(memberId);
    }
}
