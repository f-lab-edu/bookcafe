package com.study.bookcafe.infrastructure.query.borrow;

import com.study.bookcafe.domain.borrow.PriorityBorrowRight;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PriorityBorrowRightTestSets {
    public static final Map<Long, PriorityBorrowRight> WORM_PRIORITY_BORROW_RIGHT_MAP = new HashMap<>(){{
        put(2L, WORM_WHITE_PRIORITY_BORROW_RIGHT);
    }};

    public static final PriorityBorrowRight WORM_WHITE_PRIORITY_BORROW_RIGHT = new PriorityBorrowRight(2L, LocalDateTime.now().minusHours(1));

    public static Map<Long, PriorityBorrowRight> createWormPriorityBorrowRightMap = new HashMap<>(){{
        put(2L, createWormWhitePriorityBorrowRight());
    }};

    public static PriorityBorrowRight createWormWhitePriorityBorrowRight() {
        return new PriorityBorrowRight(2L, LocalDateTime.now().minusHours(1));
    }
}
