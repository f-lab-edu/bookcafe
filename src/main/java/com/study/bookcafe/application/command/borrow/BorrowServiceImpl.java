package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.Return;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend) {
        return borrowRepository.findBorrowByMemberIdAndBookId(memberId, bookId, canExtend);
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(final long memberId, final long bookId) {
        return borrowRepository.findBorrowByMemberIdAndBookId(memberId, bookId);
    }

    /**
     * 새로운 대출을 저장한다.
     *
     * @param borrow  대출 정보
     */
    @Override
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    /**
     * 새로운 여러 대출들을 저장한다.
     *
     * @param borrows 대출 목록
     */
    @Override
    public void save(Collection<Borrow> borrows) {
        borrowRepository.save(borrows);
    }

    @Override
    public void updatePeriod(Borrow borrow) {
        borrowRepository.updatePeriod(borrow);
    }

    /**
     * 새로운 예약을 저장한다.
     *
     * @param reservation 예악 정보
     */
    @Override
    public void save(Reservation reservation) {
        borrowRepository.save(reservation);
    }

    /**
     * 예약을 취소한다.
     *
     * @param reservationId 예약 ID
     */
    @Override
    public void cancelReservation(long reservationId) {
        borrowRepository.cancelReservation(reservationId);
    }

    @Override
    public void returnBook(final Return returnInfo) {
        borrowRepository.returnBook(returnInfo);
    }

}
