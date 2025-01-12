package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.command.borrow.Reservation;
import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.domain.query.member.MembersReservationDetails;
import java.time.LocalDateTime;

public class BorrowTestSets {

    public static LocalDateTime now = LocalDateTime.now();

    /************************* Borrow *************************/
    public static final BorrowEntity BASIC_VEGETARIAN_BORROW_ENTITY = BorrowEntity.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_ENTITY)
            .book(BookTestSets.VEGETARIAN_BOOK_ENTITY)
            .time(now)
            .build();

    public static final BorrowEntity WORM_WHITE_BORROW_ENTITY = BorrowEntity.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER_ENTITY)
            .book(BookTestSets.WHITE_BOOK_ENTITY)
            .time(now)
            .build();

    /************************* BorrowDetails *************************/
    public static final BorrowDetails MEMBER_BORROWDETAILS_1 = BorrowDetails.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.VEGETARIAN_BOOK_VIEW)
            .time(now)
            .build();

    public static final BorrowDetails MEMBER_BORROWDETAILS_2 = BorrowDetails.builder()
            .id(2)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.WHITE_BOOK_VIEW)
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
