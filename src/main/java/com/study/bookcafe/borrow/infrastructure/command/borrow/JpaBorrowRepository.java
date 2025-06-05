package com.study.bookcafe.borrow.infrastructure.command.borrow;

import com.study.bookcafe.borrow.domain.borrow.Borrow;
import com.study.bookcafe.borrow.domain.borrow.BorrowRepository;
import com.study.bookcafe.borrow.interfaces.borrow.BorrowMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBorrowRepository implements BorrowRepository {

    @PersistenceContext
    private EntityManager em;

    private final BorrowMapper borrowMapper;

    public JpaBorrowRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Override
    public void save(Borrow borrow) {
        em.persist(borrowMapper.toBorrowEntity(borrow));
    }
}
