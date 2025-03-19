package com.study.bookcafe.infrastructure.command.reservation;

import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.book.TestBookQueryStorage;
import com.study.bookcafe.infrastructure.query.member.TestMemberQueryStorage;
import com.study.bookcafe.infrastructure.query.reservation.TestReservationQueryStorage;
import com.study.bookcafe.interfaces.reservation.ReservationMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
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
    public void save(final Reservation reservation) {
        final var reservationEntity = reservationMapper.toReservationEntity(reservation);

        TestReservationQueryStorage.reservationEntities.put(reservationEntity.getId(), reservationEntity);
        TestMemberQueryStorage.memberEntities.put(reservationEntity.getMember().getId(), reservationEntity.getMember());
        TestBookQueryStorage.bookInventoryEntities.put(reservationEntity.getBook().getId(), reservationEntity.getBook());
    }

    @Override
    public void delete(final Reservation reservation) {
        final var reservationEntity = reservationMapper.toReservationEntity(reservation);

        this.deleteById(reservationEntity.getId());

        Optional.ofNullable(TestMemberQueryStorage.memberEntities.get(reservationEntity.getMember().getId()))
                .map(memberEntity -> TestMemberQueryStorage.memberEntities.put(memberEntity.getId(), reservationEntity.getMember()))
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));

        Optional.ofNullable(TestBookQueryStorage.bookInventoryEntities.get(reservationEntity.getBook().getId()))
                .map(bookEntity -> TestBookQueryStorage.bookInventoryEntities.put(bookEntity.getId(), reservationEntity.getBook()))
                .orElseThrow(() -> new IllegalArgumentException("도서 정보를 찾을 수 없습니다."));
    }

    @Override
    public void deleteById(final long reservationId) {
        findById(reservationId)
                .map(reservation -> TestReservationQueryStorage.reservationEntities.remove(reservation.getId()))
                .orElseThrow(() -> new IllegalArgumentException("예약 정보를 찾을 수 없습니다."));
    }
}
