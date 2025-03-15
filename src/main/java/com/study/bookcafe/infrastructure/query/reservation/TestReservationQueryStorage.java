package com.study.bookcafe.infrastructure.query.reservation;

import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.infrastructure.query.member.MemberTestSets;
import com.study.bookcafe.query.reservation.ReservationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestReservationQueryStorage {


    /************************* Command *************************/
    public static Map<Long, Reservation> reservations =
            Stream.of(
                    ReservationTestSets.BASIC_MEMBER_RESERVATION,
                    ReservationTestSets.WORM_MEMBER_RESERVATION
            ).collect(Collectors.toMap(
                    Reservation::getId,
                    reservation -> reservation
            ));

    public static Map<Long, ReservationEntity> reservationEntities =
            Stream.of(
                    ReservationTestSets.BASIC_MEMBER_RESERVATION_ENTITY,
                    ReservationTestSets.WORM_MEMBER_RESERVATION_ENTITY
            ).collect(Collectors.toMap(
                    ReservationEntity::getId,
                    reservationEntity -> reservationEntity
            ));

    public static final Map<Long, List<ReservationView>> membersReservationViews = new HashMap<>(){{
        put(MemberTestSets.BASIC_MEMBER_VIEW.getId(), new ArrayList<>(List.of(ReservationTestSets.BASIC_MEMBER_RESERVATION_VIEW)));
        put(MemberTestSets.WORM_MEMBER.getId(), new ArrayList<>(List.of(ReservationTestSets.WORM_MEMBER_RESERVATION_VIEW)));
    }};

    // memberId, reservation
//    public static final Map<Long, List<MembersReservationDetails>> membersReservations = new HashMap<>(){{
//        put(MemberTestSets.BASIC_MEMBER.getId(), new ArrayList<>(List.of(BorrowTestSets.MEMBERS_RESERVATION_DETAILS_1, BorrowTestSets.MEMBERS_RESERVATION_DETAILS_2)));
//    }};
}
