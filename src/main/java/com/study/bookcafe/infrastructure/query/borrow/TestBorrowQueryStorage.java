package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.domain.borrow.Return;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBorrowQueryStorage {


    /************************* Command *************************/
    public static Map<Long, BorrowEntity> borrowEntities =
            Stream.of(
                    BorrowTestSets.BASIC_VEGETARIAN_BORROW_ENTITY,
                    BorrowTestSets.WORM_WHITE_BORROW_ENTITY
            ).collect(Collectors.toMap(
                    BorrowEntity::getId,
                    borrowEntity -> borrowEntity
            ));

    public static Map<Long, BorrowDto> borrowDtos =
            Stream.of(
                    BorrowTestSets.BASIC_VEGETARIAN_BORROW_DTO,
                    BorrowTestSets.WORM_WHITE_BORROW_DTO
            ).collect(Collectors.toMap(
                    BorrowDto::getId,
                    borrowDto -> borrowDto
            ));

    public static Map<Long, Reservation> reservations =
            Stream.of(
                    BorrowTestSets.BASIC_MEMBER_RESERVATION,
                    BorrowTestSets.WORM_MEMBER_RESERVATION
            ).collect(Collectors.toMap(
                    Reservation::getId,
                    reservation -> reservation
            ));

    /************************* Query *************************/
    public static final Map<Long, BorrowDetails> borrowsDetails =
            Stream.of(
                    BorrowTestSets.MEMBER_BORROWDETAILS_1,
                    BorrowTestSets.MEMBER_BORROWDETAILS_2
            ).collect(Collectors.toMap(
                    BorrowDetails::getId,
                    borrowDetails -> borrowDetails
            ));

    // memberId, Borrow
    public static final Map<Long, List<Borrow>> membersBorrows = new HashMap<>(){{
        put(1L, new ArrayList<>(List.of(BorrowTestSets.BASIC_VEGETARIAN_BORROW)));
        put(2L, new ArrayList<>(List.of(BorrowTestSets.WORM_WHITE_BORROW)));
    }};

    // memberId, reservation
    public static final Map<Long, List<MembersReservationDetails>> membersReservations = new HashMap<>(){{
        put(1L, new ArrayList<>(List.of(BorrowTestSets.MEMBERS_RESERVATION_DETAILS_1, BorrowTestSets.MEMBERS_RESERVATION_DETAILS_2)));
    }};

    public static final Map<Long, List<Return>> membersBorrowsHistory = new HashMap<>(){{
        put(1L, new ArrayList<>());
        put(2L, new ArrayList<>());
    }};

}
