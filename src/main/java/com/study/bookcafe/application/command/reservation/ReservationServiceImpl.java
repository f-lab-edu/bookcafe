package com.study.bookcafe.application.command.reservation;

import com.study.bookcafe.application.command.book.BookService;
import com.study.bookcafe.application.command.member.MemberService;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberService memberService;
    private final BookService bookService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, MemberService memberService, BookService bookService) {
        this.reservationRepository = reservationRepository;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    @Override
    public Reservation findById(final long reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(() -> new IllegalArgumentException("예약 정보를 찾을 수 없습니다."));
    }

    @Override
    public void reserve(final long memberId, final long bookId) {
        Member member = memberService.findById(memberId);
        Book book = bookService.findById(bookId);

        reservationRepository.save(Reservation.of(member, book));
    }

    @Override
    public void cancelReservation(final long reservationId) {
        reservationRepository.cancelReservation(findById(reservationId));
    }
}
