package com.study.bookcafe.application.command.reservation;

import com.study.bookcafe.domain.reservation.Reservation;

public interface ReservationService {
    Reservation findById(long reservationId);
    void reserve(long memberId, long bookId);
    void cancel(long reservationId);
}
