package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Return;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.query.borrow.BorrowDetails;

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

    public static final Map<Long, List<Return>> membersBorrowsHistory = new HashMap<>(){{
        put(1L, new ArrayList<>());
        put(2L, new ArrayList<>());
    }};

}
