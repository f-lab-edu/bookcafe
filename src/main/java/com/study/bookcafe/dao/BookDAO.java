package com.study.bookcafe.dao;

import com.study.bookcafe.dto.BookDTO;
import com.study.bookcafe.entity.Inventory;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookDAO {

    public static Map<Long, BookDTO> books = new HashMap<>(){{
        put(1L, BookDTO.builder().bookId(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비").publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build());
        put(2L, BookDTO.builder().bookId(2L).ISBN(9788954651134L).title("흰").author("한강").publisher("문학동네").publishDate(Date.valueOf(LocalDate.of(2018, 4, 25)))
                .price(13000).inventory(new Inventory(0)).build());
    }};

    public BookDTO findById(long bookId) {
        // 추후 DB 연결 후 재작성
        return books.get(bookId);
    }
}
