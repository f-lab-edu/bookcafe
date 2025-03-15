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
        return Optional.ofNullable(TestReservationQueryStorage.reservations.get(reservationId));
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

        TestReservationQueryStorage.membersReservationViews.get(reservationEntity.getMember().getId())
                .removeIf(target -> target.getId() == reservationEntity.getId());
    }
}
