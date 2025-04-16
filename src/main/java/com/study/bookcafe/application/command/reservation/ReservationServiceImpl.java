package com.study.bookcafe.application.command.reservation;

import com.study.bookcafe.application.command.book.BookInventoryService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberService memberService;
    private final BookInventoryService bookInventoryService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, MemberService memberService, BookInventoryService bookInventoryService) {
        this.reservationRepository = reservationRepository;
        this.memberService = memberService;
        this.bookInventoryService = bookInventoryService;
    }

    @Override
    public Optional<Reservation> findById(final long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public Optional<Reservation> findByMemberIdAndBookId(long memberId, long bookId) {
        return reservationRepository.findByMemberIdAndBookId(memberId, bookId);
    }

    @Override
    public Optional<Reservation> findFirstByBookId(long bookId) {
        return reservationRepository.findFirstByBookId(bookId);
    }

    @Override
    public void reserve(final long memberId, final long bookId) {
        Member member = memberService.findById(memberId);
        BookInventory book = bookInventoryService.findByBookId(bookId);

        reservationRepository.save(Reservation.of(member, book));
    }

    @Override
    @Transactional
    public void cancel(final long reservationId) {
        this.delete(reservationId);
    }

    @Override
    @Transactional
    public void removeDueToBorrow(final long memberId, final long bookId) {
        findByMemberIdAndBookId(memberId, bookId).ifPresent(this::delete);
    }

    @Override
    @Transactional
    public void delete(final long reservationId) {
        Reservation reservation = findById(reservationId).orElseThrow(() -> new IllegalArgumentException("예약 정보를 찾을 수 없습니다."));
        this.delete(reservation);
    }

    @Override
    @Transactional
    public void delete(final Reservation reservation) {
        reservation.decreaseReservationCount();

        reservationRepository.deleteById(reservation.getId());
        reservationRepository.updateReservationCount(reservation);
    }
}
