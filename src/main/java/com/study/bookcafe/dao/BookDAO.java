package com.study.bookcafe.dao;

import com.study.bookcafe.dto.BookDTO;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookDAO {

    Map<Long, BookDTO> books = new HashMap<>(){{
        put(1L, new BookDTO(9788936433598L, "채식주의자", "한강", "창비", Date.valueOf(LocalDate.of(2007, 10, 30)), 35000));
        put(2L, new BookDTO(9788936433598L, "채식주의자", "한강", "창비", Date.valueOf(LocalDate.of(2018, 4, 25)), 13000));
    }};

    public BookDTO findById(long bookId) {
        // 추후 DB 연결 후 재작성
        return books.get(bookId);
    }
}
