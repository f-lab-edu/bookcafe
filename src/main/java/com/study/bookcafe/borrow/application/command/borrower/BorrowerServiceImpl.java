package com.study.bookcafe.borrow.application.command.borrower;

import com.study.bookcafe.borrow.domain.borrower.Borrower;
import com.study.bookcafe.borrow.domain.borrower.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public Optional<Borrower> findById(long memberId) {
        return borrowerRepository.findById(memberId);
    }
}
