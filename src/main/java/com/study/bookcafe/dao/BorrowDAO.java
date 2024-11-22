package com.study.bookcafe.dao;

import com.study.bookcafe.dto.BorrowDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BorrowDAO {
    Map<Long, BorrowDTO> borrows = new HashMap<>(){{
        put(1L, new BorrowDTO(1, 1, 9788936433598L));
        put(2L, new BorrowDTO(1, 2, 9788936433598L));
        put(3L, null);
    }};

    public BorrowDTO find(long memberId, long bookId, long ISBN) {
        // 추후 DB 연결 후 재작성
        return borrows.get(memberId);
    }

    public void save(BorrowDTO borrowDTO) {
        // 추후 DB 연결 후 작성
    }
}
