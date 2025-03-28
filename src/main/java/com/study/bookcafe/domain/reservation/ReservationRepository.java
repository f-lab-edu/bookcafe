package com.study.bookcafe.domain.reservation;

import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(long reservationId);
    Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId);
    void save(Reservation reservation);
    void deleteById(long reservationId);
    void updateReservationCount(Reservation reservation);
}
