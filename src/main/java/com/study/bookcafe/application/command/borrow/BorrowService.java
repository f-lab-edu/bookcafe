package com.study.bookcafe.application.command.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import java.util.Optional;

public interface BorrowService {

    // 도서 대출 조회
    Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend);
    Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId);
    void borrow(long memberId, long bookId);
    void extend(long memberId, long bookId);
    void returnBook(long memberId, long bookId);
}