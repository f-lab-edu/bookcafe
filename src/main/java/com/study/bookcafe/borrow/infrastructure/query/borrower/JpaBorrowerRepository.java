package com.study.bookcafe.borrow.infrastructure.query.borrower;

import com.study.bookcafe.borrow.domain.borrower.Borrower;
import com.study.bookcafe.borrow.domain.borrower.BorrowerRepository;
import com.study.bookcafe.borrow.interfaces.borrower.BorrowerMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaBorrowerRepository implements BorrowerRepository {

    @PersistenceContext
    EntityManager em;

    BorrowerMapper borrowerMapper;

    public JpaBorrowerRepository(BorrowerMapper borrowerMapper) {
        this.borrowerMapper = borrowerMapper;
    }

    @Override
    public Optional<Borrower> findById(long id) {
        return Optional.ofNullable(em.find(BorrowerEntity.class, id)).map(borrowerMapper::toBorrower);
    }
}
