package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import java.util.Collection;

public interface BorrowService {

    // 도서 대출 저장
    void save(Borrow borrow);
    void save(Collection<Borrow> borrows);

    // 도서 예약 저장
    void save(Reservation reservation);
    // 도서 예약 취소
    void cancelReservation(long reservationId);
}