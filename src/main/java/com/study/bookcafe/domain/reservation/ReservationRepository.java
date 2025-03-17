package com.study.bookcafe.domain.reservation;

import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(long reservationId);
    void save(Reservation reservation);
    void deleteById(long reservationId);
}
