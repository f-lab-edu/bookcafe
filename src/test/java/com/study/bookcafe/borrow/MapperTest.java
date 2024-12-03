package com.study.bookcafe.borrow;

import com.google.gson.Gson;
import com.study.bookcafe.common.JsonHelper;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.dto.BookDto;
import com.study.bookcafe.dto.BorrowDto;
import com.study.bookcafe.dto.MemberDto;
import com.study.bookcafe.entity.BookEntity;
import com.study.bookcafe.entity.BorrowEntity;
import com.study.bookcafe.entity.MemberEntity;
import com.study.bookcafe.mapper.BorrowMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {
    @Autowired
    private final BorrowMapper borrowMapper = Mappers.getMapper(BorrowMapper.class);

    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("Mapper 테스트 : Borrow -> BorrowDto")
    public void checkMapperBorrowToBorrowDto() {
        Borrow borrow = Borrow.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(1).ISBN(9788936433598L).build()).build();
        BorrowDto borrowDto = borrowMapper.toBorrowDto(borrow);

        System.out.println(gson.toJson(borrowDto));
    }

    @Test
    @DisplayName("Mapper 테스트 : BorrowDto -> Borrow")
    public void checkMapperBorrowDtoToBorrow() {
        BorrowDto borrowDto = BorrowDto.builder()
                .member(MemberDto.builder().id(1).build())
                .book(BookDto.builder().id(1).ISBN(9788936433598L).build()).build();
        Borrow borrow = borrowMapper.toBorrow(borrowDto);

        System.out.println(gson.toJson(borrow));
    }

    @Test
    @DisplayName("Mapper 테스트 : Borrow -> BorrowEntity")
    public void checkMapperBorrowToBorrowEntity() {
        Borrow borrow = Borrow.builder()
                .member(Member.builder().id(1).build())
                .book(Book.builder().id(1).ISBN(9788936433598L).build()).build();
        BorrowEntity borrowEntity = borrowMapper.toBorrowEntity(borrow);

        System.out.println(gson.toJson(borrowEntity));
    }

    @Test
    @DisplayName("Mapper 테스트 : BorrowEntity -> Borrow")
    public void checkMapperBorrowEntityToBorrow() {
        BorrowEntity borrowEntity = BorrowEntity.builder()
                .member(MemberEntity.builder().id(1).build())
                .book(BookEntity.builder().id(1).ISBN(9788936433598L).build()).build();
        Borrow borrow = borrowMapper.toBorrow(borrowEntity);

        System.out.println(gson.toJson(borrow));
    }
}
