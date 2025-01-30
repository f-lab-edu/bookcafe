package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowTestSets {

    public static LocalDateTime now = LocalDateTime.now();

    public static final BorrowPeriod BASIC_PERIOD = BorrowPeriod.of(LocalDate.now().minusDays(3), Level.BASIC);
    public static final BorrowPeriod WORM_PERIOD = BorrowPeriod.of(LocalDate.now().minusDays(8), Level.WORM);

    /************************* Borrow *************************/
    public static final Borrow BASIC_VEGETARIAN_BORROW = Borrow.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER)
            .book(BookTestSets.VEGETARIAN_BOOK)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final Borrow WORM_WHITE_BORROW = Borrow.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER)
            .book(BookTestSets.WHITE_BOOK)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    public static final BorrowEntity BASIC_VEGETARIAN_BORROW_ENTITY = BorrowEntity.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_ENTITY)
            .book(BookTestSets.VEGETARIAN_BOOK_ENTITY)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowEntity WORM_WHITE_BORROW_ENTITY = BorrowEntity.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER_ENTITY)
            .book(BookTestSets.WHITE_BOOK_ENTITY)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    public static final BorrowDto BASIC_VEGETARIAN_BORROW_DTO = BorrowDto.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_DTO)
            .book(BookTestSets.VEGETARIAN_BOOK_DTO)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowDto WORM_WHITE_BORROW_DTO = BorrowDto.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER_DTO)
            .book(BookTestSets.WHITE_BOOK_DTO)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    /************************* BorrowDetails *************************/
    public static final BorrowDetails MEMBER_BORROWDETAILS_1 = BorrowDetails.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.VEGETARIAN_BOOK_VIEW)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowDetails MEMBER_BORROWDETAILS_2 = BorrowDetails.builder()
            .id(2)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.WHITE_BOOK_VIEW)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    /************************* Reservation *************************/
    public static final Reservation BASIC_MEMBER_RESERVATION = Reservation.builder()
            .id(1L)
            .memberId(MemberTestSets.BASIC_MEMBER_ENTITY.getId())
            .bookId(1L)
            .time(now)
            .build();

    public static final Reservation WORM_MEMBER_RESERVATION = Reservation.builder()
            .id(2L)
            .memberId(MemberTestSets.WORM_MEMBER_ENTITY.getId())
            .bookId(1L)
            .time(now)
            .build();

    /************************* MembersReservationDetails *************************/
    public static final MembersReservationDetails MEMBERS_RESERVATION_DETAILS_1 = MembersReservationDetails.builder()
            .id(1L)
            .book(BookTestSets.VEGETARIAN_BOOK_VIEW)
            .order(1)
            .build();

    public static final MembersReservationDetails MEMBERS_RESERVATION_DETAILS_2 = MembersReservationDetails.builder()
            .id(2L)
            .book(BookTestSets.WHITE_BOOK_VIEW)
            .order(1)
            .build();

}
