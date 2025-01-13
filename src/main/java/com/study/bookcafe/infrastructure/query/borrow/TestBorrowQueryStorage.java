package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.query.borrow.BorrowDetails;
import com.study.bookcafe.query.member.MembersReservationDetails;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBorrowQueryStorage {


    /************************* Command *************************/
    public static Map<Long, BorrowEntity> borrows =
            Stream.of(
                    BorrowTestSets.BASIC_VEGETARIAN_BORROW_ENTITY,
                    BorrowTestSets.WORM_WHITE_BORROW_ENTITY
            ).collect(Collectors.toMap(
                    BorrowEntity::getId,
                    borrowEntity -> borrowEntity
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

    // memberId, reservation
    public static final Map<Long, List<MembersReservationDetails>> membersReservations = new HashMap<>(){{
        put(1L, new ArrayList<>(List.of(BorrowTestSets.MEMBERS_RESERVATION_DETAILS_1, BorrowTestSets.MEMBERS_RESERVATION_DETAILS_2)));
    }};
}
