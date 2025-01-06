package com.study.bookcafe.application.borrow;

import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.BorrowDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    /**
     * 새로운 대출을 저장한다.
     *
     * @param borrow  대출 정보
     * @return 생성한 대출 정보
     */
    @Override
    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    /**
     * 새로운 여러 대출들을 저장한다.
     *
     * @param borrows 대출 목록
     * @return 생성한 대출 정보 목록
     */
    @Override
    public List<Borrow> save(Collection<Borrow> borrows) {
        return borrowRepository.save(borrows);
    }

    /**
     * 대출 목록을 조회한다.
     *
     * @param memberId 회원 ID
     * @return 대출 목록
     */
    @Override
    public List<BorrowDetails> findBorrows(long memberId) {
        return borrowRepository.findByMemberId(memberId);
    }

    /**
     * 새로운 예약을 저장한다.
     *
     * @param reservation 예악 정보
     * @return 생성한 예약 정보
     */
    @Override
    public Reservation save(Reservation reservation) {
        return borrowRepository.save(reservation);
    }

}
