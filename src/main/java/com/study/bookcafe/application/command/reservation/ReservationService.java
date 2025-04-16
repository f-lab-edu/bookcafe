package com.study.bookcafe.application.command.reservation;

import com.study.bookcafe.domain.reservation.Reservation;

import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> findById(long reservationId);
    Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId);
    Optional<Reservation> findFirstByBookId(long bookId);
    void reserve(long memberId, long bookId);
    void cancel(long reservationId);
    void removeDueToBorrow(long memberId, long bookId);
    void delete(long reservationId);
    void delete(Reservation reservation);
}
