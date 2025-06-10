package com.study.bookcafe.reservation.application.event;

import com.study.bookcafe.borrow.application.event.BorrowEvent;
import com.study.bookcafe.reservation.application.command.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BorrowEventListener {
    private final ReservationService reservationService;

    @EventListener
    public void deletePriorityBorrowReservation(BorrowEvent event) {
        reservationService.deleteDueToBorrow(event.getMemberId(), event.getBookId());
    }
}
