package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.command.book.Book;
import com.study.bookcafe.domain.command.borrow.Reservation;
import com.study.bookcafe.domain.query.book.BookView;
import com.study.bookcafe.domain.query.borrow.BorrowDetails;
import com.study.bookcafe.domain.query.member.MemberView;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import com.study.bookcafe.interfaces.member.MembersReservationDetails;

import java.time.LocalDateTime;
import java.util.*;

public class TestBorrowQueryStorage {

    /************************* Command *************************/
    public static Map<Long, BorrowEntity> borrows = new HashMap<>(){{
        put(1L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(1).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(2L, BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(2).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(3L, null);
    }};

    // memberId, reservation
    public static Map<Long, Reservation> reservations = new HashMap<>(){{
        put(1L, Reservation.builder()
                .id(1L)
                .memberId(1L)
                .bookId(1L)
                .time(LocalDateTime.now())
                .build());
        put(2L, Reservation.builder()
                .id(2L)
                .memberId(2L)
                .bookId(1L)
                .time(LocalDateTime.now())
                .build());
    }};

    /************************* Query *************************/
    public static final Map<Long, BorrowDetails> borrowsDetails = new HashMap<>(){{
        put(1L, BorrowDetails.builder()
                .member(MemberView.builder().id(1).build())
                .book(BookView.builder().id(1).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
        put(2L, BorrowDetails.builder()
                .member(MemberView.builder().id(1).build())
                .book(BookView.builder().id(2).ISBN(9788936433598L).build())
                .time(LocalDateTime.now())
                .build());
    }};

    // memberId, reservation
    public static final Map<Long, List<MembersReservationDetails>> membersReservations = new HashMap<>(){{
        put(1L, new ArrayList<>(List.of(MembersReservationDetails.builder()
                .id(1L)
                .book(Book.builder().id(1L).build())
                .order(1)
                .build()))
        );
    }};
}
