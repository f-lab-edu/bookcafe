package com.study.bookcafe.reservation.application.event;

import com.study.bookcafe.borrow.application.event.BorrowEvent;
import com.study.bookcafe.reservation.application.command.reservation.ReservationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BorrowEventListener {

    ReservationService reservationService;

    public BorrowEventListener(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @EventListener
    public void deletePriorityBorrowReservation(BorrowEvent event) {
        reservationService.deleteDueToBorrow(event.getMemberId(), event.getBookId());
    }
}
