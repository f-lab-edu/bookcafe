package com.study.bookcafe.infrastructure.command.borrow;

import com.study.bookcafe.domain.command.borrow.Reservation;
import com.study.bookcafe.domain.command.borrow.Borrow;
import com.study.bookcafe.domain.command.borrow.BorrowRepository;
import com.study.bookcafe.infrastructure.query.borrow.BorrowEntity;
import com.study.bookcafe.infrastructure.query.borrow.TestBorrowQueryStorage;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import com.study.bookcafe.interfaces.member.MembersReservationDetails;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class TestBorrowRepository implements BorrowRepository {

    private final BorrowMapper borrowMapper;

    public TestBorrowRepository(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    public void save(Borrow borrow) {
        BorrowEntity borrowEntity = TestBorrowQueryStorage.borrows.get(borrow.getId());
        borrowMapper.toBorrow(borrowEntity);
    }

    @Override
    public void save(Collection<Borrow> borrows) {
        List<BorrowEntity> borrowEntities = borrows
                .stream().filter(borrow -> TestBorrowQueryStorage.borrows.containsKey(borrow.getId()))
                .map(borrow -> TestBorrowQueryStorage.borrows.get(borrow.getId())).toList();
        borrowMapper.toBorrows(borrowEntities);
    }

    @Override
    public void save(Reservation reservation) {
        TestBorrowQueryStorage.reservations.put(reservation.getMemberId(), reservation);
    }

    @Override
    public void cancelReservation(long reservationId) {
        long memberId = 1L;

        MembersReservationDetails membersReservationDetails = TestBorrowQueryStorage.membersReservations.get(memberId).stream()
                .filter(reservation -> reservation.getId() == reservationId)
                .findFirst()
                .get();

        TestBorrowQueryStorage.membersReservations.get(memberId).remove(membersReservationDetails);
    }
}
