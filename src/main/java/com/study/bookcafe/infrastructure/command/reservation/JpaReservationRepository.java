package com.study.bookcafe.infrastructure.command.reservation;

import com.study.bookcafe.domain.borrow.PriorityBorrowPeriod;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.interfaces.reservation.ReservationMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("jpa")
public class JpaReservationRepository implements ReservationRepository {

    private final ReservationMapper reservationMapper;

    public JpaReservationRepository(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Optional<Reservation> findById(long reservationId) {
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId) {
        return Optional.empty();
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public void deleteById(long reservationId) {

    }

    @Override
    public void updateReservationCount(Reservation reservation) {

    }

    @Override
    public void selectPriorityReservation(long bookId, PriorityBorrowPeriod period) {

    }
}
