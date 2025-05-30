package com.study.bookcafe.infrastructure.command.reservation;

import com.study.bookcafe.domain.borrow.PriorityBorrowPeriod;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.book.TestBookQueryStorage;
import com.study.bookcafe.infrastructure.query.member.TestMemberQueryStorage;
import com.study.bookcafe.infrastructure.query.reservation.ReservationEntity;
import com.study.bookcafe.infrastructure.query.reservation.TestReservationQueryStorage;
import com.study.bookcafe.interfaces.reservation.ReservationMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Optional;

@Repository
@Profile("test")
public class TestReservationRepository implements ReservationRepository {

    private final ReservationMapper reservationMapper;

    public TestReservationRepository(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Optional<Reservation> findById(final long reservationId) {
        return Optional.ofNullable(TestReservationQueryStorage.reservationEntities.get(reservationId))
                .map(reservationMapper::toReservation);
    }

    @Override
    public Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId) {
        return TestReservationQueryStorage.reservationEntities.values().stream()
                .map(reservationMapper::toReservation)
                .filter(reservationEntity ->
                        reservationEntity.getMember().getId() == memberId &&
                                reservationEntity.getBook().getBookId() == bookId).findFirst();
    }

    @Override
    public Optional<Reservation> findPriorityByMemberIdAndBookId(long memberId, long bookId) {
        return Optional.empty();
    }

    @Override
    public void save(final Reservation reservation) {
        final var reservationEntity = reservationMapper.toReservationEntity(reservation);

        TestReservationQueryStorage.reservationEntities.put(reservationEntity.getId(), reservationEntity);
        TestMemberQueryStorage.memberEntities.put(reservationEntity.getMember().getId(), reservationEntity.getMember());
        TestBookQueryStorage.bookInventoryEntities.put(reservationEntity.getBook().getId(), reservationEntity.getBook());
    }

    @Override
    public void deleteById(final long reservationId) {
        findById(reservationId)
                .map(reservation -> TestReservationQueryStorage.reservationEntities.remove(reservation.getId()))
                .orElseThrow(() -> new IllegalArgumentException("예약 정보를 찾을 수 없습니다."));
    }

    @Override
    public void updateReservationCount(Reservation reservation) {
        this.updateMemberReservationCount(reservation);
        this.updateBookReservationCount(reservation);
    }

    @Override
    public void selectPriorityReservation(long bookId, PriorityBorrowPeriod period) {

        // bookId로 찾은 예약 목록 중 우선대출 중이 아닌(우선대출 기간 = null) 가장 첫번째 예약에 기간을 세팅
        Optional<Reservation> target = TestReservationQueryStorage.reservationEntities.values().stream()
                .filter(reservationEntity -> reservationEntity.getBook().getBookId() == bookId && reservationEntity.getPriorityBorrowPeriod() != null)
                .min(Comparator.comparing(reservationEntity -> reservationEntity.getMember().getId()))
                .map(reservationMapper::toReservation);

        target.ifPresent(reservation -> {
            reservation.setPriorityBorrowPeriod(period);
            ReservationEntity reservationEntity = reservationMapper.toReservationEntity(reservation);

            TestReservationQueryStorage.reservationEntities.put(reservationEntity.getId(), reservationEntity);
        });

    }

    private void updateMemberReservationCount(final Reservation reservation) {
        final var reservationEntity = reservationMapper.toReservationEntity(reservation);

        Optional.ofNullable(TestMemberQueryStorage.memberEntities.get(reservationEntity.getMember().getId()))
                .map(memberEntity -> TestMemberQueryStorage.memberEntities.put(memberEntity.getId(), reservationEntity.getMember()))
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));
    }

    private void updateBookReservationCount(final Reservation reservation) {
        final var reservationEntity = reservationMapper.toReservationEntity(reservation);

        Optional.ofNullable(TestBookQueryStorage.bookInventoryEntities.get(reservationEntity.getBook().getId()))
                .map(bookEntity -> TestBookQueryStorage.bookInventoryEntities.put(bookEntity.getId(), reservationEntity.getBook()))
                .orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }
}
