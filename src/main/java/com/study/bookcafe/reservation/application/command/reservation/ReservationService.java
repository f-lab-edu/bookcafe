package com.study.bookcafe.reservation.application.command.reservation;

import com.study.bookcafe.reservation.domain.book.BookInventory;
import com.study.bookcafe.reservation.domain.reservation.Reservation;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> findById(long reservationId);
    Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId);
//    Optional<Reservation> findPriorityReservationByBookId(long bookId);
    Optional<Reservation> findPriorityByMemberIdAndBookId(long memberId, long bookId);
    void reserve(long memberId, long bookId);
    void cancel(long reservationId);
    void deleteDueToBorrow(long memberId, long bookId);
    void delete(long reservationId);
    void delete(Reservation reservation);
    void selectPriorityReservation(BookInventory book, LocalDateTime date);
    void relinquish(long memberId, long bookId);
}
