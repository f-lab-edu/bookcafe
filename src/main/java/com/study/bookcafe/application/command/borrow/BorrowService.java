package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import java.util.Collection;
import java.util.Optional;

public interface BorrowService {

    // 도서 대출 조회
    Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend);

    // 도서 대출 저장
    void save(Borrow borrow);
    void save(Collection<Borrow> borrows);

    // 도서 대출 연장
    void updatePeriod(Borrow borrow);

    // 도서 예약 저장
    void save(Reservation reservation);
    // 도서 예약 취소
    void cancelReservation(long reservationId);
}