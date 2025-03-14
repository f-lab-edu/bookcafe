package com.study.bookcafe.domain.borrow;

import java.util.Collection;
import java.util.Optional;

public interface BorrowRepository {

    void save(Borrow borrow);
    void save(Collection<Borrow> borrows);
    void save(Reservation reservation);
    void cancelReservation(long reservationId);
    Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend);
    Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId);
    void updatePeriod(Borrow borrow);
    void save(Return returnInfo);
}
