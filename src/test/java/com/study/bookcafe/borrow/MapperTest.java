package com.study.bookcafe.borrow;

import com.google.gson.Gson;
import com.study.bookcafe.book.BookTest;
import com.study.bookcafe.domain.borrow.BorrowPeriod;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.infrastructure.query.borrow.BorrowEntity;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.member.Level;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.interfaces.book.BookDto;
import com.study.bookcafe.interfaces.borrow.BorrowDto;
import com.study.bookcafe.interfaces.member.MemberDto;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MapperTest {
    @Autowired
    private final BorrowMapper borrowMapper = Mappers.getMapper(BorrowMapper.class);

    private final Gson gson = JsonHelper.getGson();

    interface BorrowObjectFactory {
        Borrow createBorrow();
        BorrowDto createBorrowDto();
        BorrowEntity createBorrowEntity();
    }

    static class BorrowFactory implements BorrowObjectFactory {
        @Override
        public Borrow createBorrow() {
            return Borrow.builder()
                    .member(Member.builder().id(1).build())
                    .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY)
                    .borrowPeriod(BorrowPeriod.of(LocalDate.now(), Level.BASIC))
                    .time(LocalDateTime.now())
                    .build();
        }

        @Override
        public BorrowDto createBorrowDto() {
            return BorrowDto.builder()
                    .member(MemberDto.builder().id(1).build())
                    .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_DTO)
                    .borrowPeriod(BorrowPeriod.of(LocalDate.now(), Level.BASIC))
                    .time(LocalDateTime.now())
                    .build();
        }

        @Override
        public BorrowEntity createBorrowEntity() {
            return BorrowEntity.builder()
                    .member(MemberEntity.builder().id(1).build())
                    .book(BookTestSets.VEGETARIAN_BOOK_INVENTORY_ENTITY)
                    .borrowPeriod(BorrowPeriod.of(LocalDate.now(), Level.BASIC))
                    .time(LocalDateTime.now())
                    .build();
        }
    }

    BorrowObjectFactory factory = new BorrowFactory();

    @Test
    @DisplayName("Mapper 테스트 : Borrow -> BorrowDto")
    public void checkMapperBorrowToBorrowDto() {
        Borrow borrow = factory.createBorrow();
        BorrowDto borrowDto = borrowMapper.toBorrowDto(borrow);

        System.out.println(gson.toJson(borrowDto));
        assertThat(borrowDto).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BorrowDto -> Borrow")
    public void checkMapperBorrowDtoToBorrow() {
        BorrowDto borrowDto = factory.createBorrowDto();
        Borrow borrow = borrowMapper.toBorrow(borrowDto);

        System.out.println(gson.toJson(borrow));
        assertThat(borrow).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : Borrow -> BorrowEntity")
    public void checkMapperBorrowToBorrowEntity() {
        Borrow borrow = factory.createBorrow();
        BorrowEntity borrowEntity = borrowMapper.toBorrowEntity(borrow);

        System.out.println(gson.toJson(borrowEntity));
        assertThat(borrowEntity).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BorrowEntity -> Borrow")
    public void checkMapperBorrowEntityToBorrow() {
        BorrowEntity borrowEntity = factory.createBorrowEntity();
        Borrow borrow = borrowMapper.toBorrow(borrowEntity);

        System.out.println(gson.toJson(borrow));
        assertThat(borrow).isNotNull();
    }
}
