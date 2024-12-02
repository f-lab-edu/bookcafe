package com.study.bookcafe.service;

import com.study.bookcafe.dao.TestBookRepository;
import com.study.bookcafe.dao.TestBorrowRepository;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.entity.BorrowEntity;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final TestBookRepository bookRepository;
    private final TestBorrowRepository borrowRepository;

    public BorrowServiceImpl(TestBookRepository bookRepository, TestBorrowRepository borrowRepository) {
        this.bookRepository = bookRepository;
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
        BorrowEntity borrowEntity = borrowRepository.save(borrow.toEntity());
        return Borrow.from(borrowEntity);
    }
}
