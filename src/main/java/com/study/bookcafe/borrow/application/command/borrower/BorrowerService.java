package com.study.bookcafe.borrow.application.command.borrower;

import com.study.bookcafe.borrow.domain.borrower.Borrower;

import java.util.Optional;

public interface BorrowerService {
    Optional<Borrower> findById(long memberId);
}
