package com.study.bookcafe.infrastructure.command.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowRepository;
import com.study.bookcafe.domain.borrow.Return;
import com.study.bookcafe.infrastructure.query.book.TestBookQueryStorage;
import com.study.bookcafe.infrastructure.query.borrow.BorrowEntity;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.infrastructure.query.member.TestMemberQueryStorage;
import com.study.bookcafe.infrastructure.query.reservation.TestReservationQueryStorage;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class TestBorrowRepository implements BorrowRepository {
    private final BorrowMapper borrowMapper;

    public TestBorrowRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    @Transactional
    @Override
    public void save(Borrow borrow) {
        BorrowEntity borrowEntity = borrowMapper.toBorrowEntity(borrow);

        TestBorrowQueryStorage.borrowEntities.put(borrowEntity.getId(), borrowEntity);
        TestMemberQueryStorage.memberEntities.put(borrowEntity.getMember().getId(), borrowEntity.getMember());
        TestBookQueryStorage.bookInventoryEntities.put(borrowEntity.getBook().getId(), borrowEntity.getBook());
    }

    @Override
    public void cancelReservation(long reservationId) {
        long memberId = 1L;

        final var targetReservationDetails =  TestReservationQueryStorage.membersReservationViews.get(memberId);

        targetReservationDetails.stream()
                .filter(reservation -> reservation.getId() == reservationId)
                .findFirst()
                .ifPresent(targetReservationDetails::remove);
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId, boolean canExtend) {
        final var targetBorrows = TestBorrowQueryStorage.membersBorrows.get(memberId);

        return targetBorrows.stream()
                .filter(borrow -> borrow.getBook().getId() == bookId)
                .filter(borrow -> borrow.haveExtendableCount() == canExtend)
                .findFirst();
    }

    @Override
    public Optional<Borrow> findBorrowByMemberIdAndBookId(long memberId, long bookId) {
        final var targetBorrows = TestBorrowQueryStorage.membersBorrows.get(memberId);

        return targetBorrows.stream()
                .filter(borrow -> borrow.getBook().getId() == bookId)
                .findFirst();
    }

    @Override
    public void updatePeriod(Borrow borrow) {
        BorrowEntity borrowEntity = borrowMapper.toBorrowEntity(borrow);

        final var targetBorrows = TestBorrowQueryStorage.borrowDtos.get(borrowEntity.getId());

        targetBorrows.setBorrowPeriod(borrow.getBorrowPeriod());
    }

    @Transactional
    @Override
    public void save(final Return returnInfo) {
        final var borrows = TestBorrowQueryStorage.membersBorrows.get(returnInfo.getMember().getId());

        borrows.removeIf(borrow -> borrow.getBook().getId() == returnInfo.getBook().getBookId());
        TestBorrowQueryStorage.membersBorrowsHistory.get(returnInfo.getMember().getId()).add(returnInfo);
    }
}
