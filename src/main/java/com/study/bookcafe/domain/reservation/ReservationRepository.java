package com.study.bookcafe.domain.reservation;

import com.study.bookcafe.domain.borrow.PriorityBorrowPeriod;

import java.util.Optional;

public interface ReservationRepository {
    Optional<Reservation> findById(long reservationId);
    Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId);
//    Optional<Reservation> findPriorityReservationByBookId(long bookId);
    void save(Reservation reservation);
    void deleteById(long reservationId);
    void updateReservationCount(Reservation reservation);
    void selectPriorityReservation(long bookId, PriorityBorrowPeriod period);
}
