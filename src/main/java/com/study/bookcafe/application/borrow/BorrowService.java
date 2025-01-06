package com.study.bookcafe.application.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.BorrowDetails;

import java.util.Collection;
import java.util.List;

public interface BorrowService {

    // 도서 대출 저장
    Borrow save(Borrow borrow);
    List<Borrow> save(Collection<Borrow> borrows);
    // 도서 대출 조회
    List<BorrowDetails> findBorrows(long memberId);

    // 도서 예약 저장
    Reservation save(Reservation reservation);
}