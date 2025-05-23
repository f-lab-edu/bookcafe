package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowTestSets {

    private static LocalDateTime now = LocalDateTime.now();

    public static final BorrowPeriod BASIC_PERIOD = BorrowPeriod.of(LocalDate.now().minusDays(3), Level.BASIC);
    public static final BorrowPeriod WORM_PERIOD = BorrowPeriod.of(LocalDate.now().minusDays(8), Level.WORM);

    /************************* Borrow *************************/
    public static final Borrow BASIC_VEGETARIAN_BORROW = Borrow.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final Borrow WORM_WHITE_BORROW = Borrow.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER)
            .book(BookTestSets.WHITE_BOOK_INVENTORY)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    public static final BorrowEntity BASIC_VEGETARIAN_BORROW_ENTITY = BorrowEntity.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_ENTITY)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_ENTITY)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowEntity WORM_WHITE_BORROW_ENTITY = BorrowEntity.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER_ENTITY)
            .book(BookTestSets.WHITE_BOOK_INVENTORY_ENTITY)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    public static final BorrowDto BASIC_VEGETARIAN_BORROW_DTO = BorrowDto.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_DTO)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_DTO)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowDto WORM_WHITE_BORROW_DTO = BorrowDto.builder()
            .id(2)
            .member(MemberTestSets.WORM_MEMBER_DTO)
            .book(BookTestSets.WHITE_BOOK_INVENTORY_DTO)
            .borrowPeriod(WORM_PERIOD)
            .time(now)
            .build();

    /************************* BorrowDetails *************************/
    public static final BorrowDetails MEMBER_BORROWDETAILS_1 = BorrowDetails.builder()
            .id(1)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_VIEW)
            .borrowPeriod(BASIC_PERIOD)
            .time(now)
            .build();

    public static final BorrowDetails MEMBER_BORROWDETAILS_2 = BorrowDetails.builder()
            .id(2)
            .member(MemberTestSets.BASIC_MEMBER_VIEW)
            .book(BookTestSets.WHITE_BOOK_INVENTORY_VIEW)
            .borrowPeriod(BASIC_PERIOD)
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

    public static Borrow createBasicVegetarianBorrow() {
        return Borrow.builder()
                .id(1)
                .member(MemberTestSets.createBasicMember())
                .book(BookTestSets.createVegetarianBookInventory())
                .borrowPeriod(BASIC_PERIOD)
                .time(now)
                .build();
    }

    public static Borrow createWormWhiteBorrow() {
        return Borrow.builder()
                .id(2)
                .member(MemberTestSets.createWormMember())
                .book(BookTestSets.createWhiteBookInventory())
                .borrowPeriod(WORM_PERIOD)
                .time(now)
                .build();
    }
}
