package com.study.bookcafe.application.query.reservation;

import com.study.bookcafe.query.reservation.ReservationQueryRepository;
import com.study.bookcafe.query.reservation.ReservationView;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {

    private final ReservationQueryRepository reservationQueryRepository;

    public ReservationQueryServiceImpl(final ReservationQueryRepository reservationQueryRepository) {
        this.reservationQueryRepository = reservationQueryRepository;
    }

    @Override
    public List<ReservationView> findMembersReservationDetails(final long memberId) {
        return reservationQueryRepository.findByMemberId(memberId);
    }
}
