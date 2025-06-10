package com.study.bookcafe.borrow.application.command.borrow;

import com.study.bookcafe.borrow.application.command.book.BookInventoryService;
import com.study.bookcafe.borrow.application.command.borrower.BorrowerService;
import com.study.bookcafe.borrow.application.event.BorrowEvent;
import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.domain.borrow.Borrow;
import com.study.bookcafe.borrow.domain.borrow.BorrowManager;
import com.study.bookcafe.borrow.domain.borrow.BorrowRepository;
import com.study.bookcafe.borrow.domain.borrower.Borrower;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service("borrowContextBorrowService")
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BorrowerService borrowerService;
    private final BookInventoryService bookInventoryService;
    private final BorrowRepository borrowRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void borrow(long memberId, long bookId) {
        Borrower borrower = borrowerService.findById(memberId).orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));
        BookInventory bookInventory = bookInventoryService.findByBookId(bookId).orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));

        BorrowManager manager = new BorrowManager(borrower, bookInventory);
        Borrow borrow = manager.borrow();

        borrowRepository.save(borrow);
        eventPublisher.publishEvent(new BorrowEvent(memberId, bookId));
    }
}
