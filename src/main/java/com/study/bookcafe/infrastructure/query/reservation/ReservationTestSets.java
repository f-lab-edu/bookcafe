package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.query.reservation.ReservationView;

import java.time.LocalDateTime;

public class ReservationTestSets {
    private static LocalDateTime now = LocalDateTime.now();

    /************************* Reservation *************************/
    public static final Reservation BASIC_MEMBER_RESERVATION = Reservation.builder()
            .id(1L)
            .member(MemberTestSets.BASIC_MEMBER)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY)
            .time(now)
            .build();

    public static final Reservation WORM_MEMBER_RESERVATION = Reservation.builder()
            .id(2L)
            .member(MemberTestSets.WORM_MEMBER)
            .book(BookTestSets.WHITE_BOOK_INVENTORY)
            .time(now)
            .build();

    public static final ReservationEntity BASIC_MEMBER_RESERVATION_ENTITY = ReservationEntity.builder()
            .id(1L)
            .member(MemberTestSets.BASIC_MEMBER_ENTITY)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_ENTITY)
            .time(now)
            .build();

    public static final ReservationEntity WORM_MEMBER_RESERVATION_ENTITY = ReservationEntity.builder()
            .id(2L)
            .member(MemberTestSets.WORM_MEMBER_ENTITY)
            .book(BookTestSets.WHITE_BOOK_INVENTORY_ENTITY)
            .time(now)
            .build();

    public static final ReservationView BASIC_MEMBER_RESERVATION_VIEW = ReservationView.builder()
            .id(1L)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_VIEW)
            .time(now)
            .order(1)
            .build();

    public static final ReservationView WORM_MEMBER_RESERVATION_VIEW = ReservationView.builder()
            .id(2L)
            .member(MemberTestSets.WORM_MEMBER_VIEW)
            .book(BookTestSets.WHITE_BOOK_INVENTORY_VIEW)
            .time(now)
            .order(2)
            .build();
}
