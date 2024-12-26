package com.study.bookcafe.application.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;

import java.util.Collection;
import java.util.List;

public interface BorrowService {
    // 대출 저장
    Borrow save(Borrow borrow);

    // 여러 대출 저장
    List<Borrow> save(Collection<Borrow> borrows);

    // 도서 예약 저장
    Reservation save(Reservation reservation);
}