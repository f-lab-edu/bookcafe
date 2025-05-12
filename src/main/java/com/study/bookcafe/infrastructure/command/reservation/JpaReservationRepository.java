package com.study.bookcafe.infrastructure.command.reservation;

import com.study.bookcafe.domain.borrow.PriorityBorrowPeriod;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import com.study.bookcafe.infrastructure.query.reservation.ReservationEntity;
import com.study.bookcafe.interfaces.reservation.ReservationMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Profile("jpa")
public class JpaReservationRepository implements ReservationRepository {

    private final ReservationMapper reservationMapper;

    @PersistenceContext
    private EntityManager em;

    public JpaReservationRepository(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Optional<Reservation> findById(long reservationId) {
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId) {
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> findPriorityByMemberIdAndBookId(long memberId, long bookId) {
        return em
                .createQuery(
                        "SELECT r FROM reservation r " +
                        "WHERE r.member.id = :memberId " +
                        "AND r.book.bookId = :bookId " +
                        "AND r.priorityBorrowPeriod IS NOT NULL", ReservationEntity.class)
                .setParameter("memberId", memberId)
                .setParameter("bookId", bookId)
                .getResultStream()
                .findAny()
                .map(reservationMapper::toReservation);
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public void deleteById(long reservationId) {

    }

    @Override
    public void updateReservationCount(Reservation reservation) {

    }

    @Override
    @Transactional
    public void selectPriorityReservation(long bookId, PriorityBorrowPeriod period) {
        em
                .createQuery(
                        "SELECT r " +
                            "FROM reservation r " +
                            "WHERE r.book.bookId = :bookId " +
                            "AND r.priorityBorrowPeriod IS NULL " +
                            "ORDER BY r.id", ReservationEntity.class)
                .setParameter("bookId", bookId)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultStream()
                .findAny()
                .ifPresent(reservationEntity -> {
                    Reservation reservation = reservationMapper.toReservation(reservationEntity);
                    reservation.setPriorityBorrowPeriod(period);

                    em.merge(reservationMapper.toReservationEntity(reservation));
                });

    }
}
