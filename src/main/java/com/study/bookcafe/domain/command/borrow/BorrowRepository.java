package com.study.bookcafe.domain.command.borrow;

import java.util.Collection;

public interface BorrowRepository {

    void save(Borrow borrow);
    void save(Collection<Borrow> borrows);
    void save(Reservation reservation);
    void cancelReservation(long reservationId);
}
