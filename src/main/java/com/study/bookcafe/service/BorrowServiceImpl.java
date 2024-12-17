package com.study.bookcafe.service;

import com.study.bookcafe.repository.BorrowRepository;
import com.study.bookcafe.domain.Borrow;
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
     * @param borrow   대출 정보
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

}
