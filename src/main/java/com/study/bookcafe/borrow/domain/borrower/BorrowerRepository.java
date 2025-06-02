package com.study.bookcafe.borrow.domain.borrower;

import java.util.Optional;

public interface BorrowerRepository {
    Optional<Borrower> findById(long id);
}
