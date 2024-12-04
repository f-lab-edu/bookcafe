package com.study.bookcafe.book;

import com.google.gson.Gson;
import com.study.bookcafe.common.JsonHelper;
import com.study.bookcafe.domain.Book;
import com.study.bookcafe.domain.Inventory;
import com.study.bookcafe.dto.BookDto;
import com.study.bookcafe.entity.BookEntity;
import com.study.bookcafe.mapper.BookMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.time.LocalDate;

public class MapperTest {
    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);
    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("Mapper 테스트 : Book -> Book")
    public void checkMapperBookToBookDto() {
        Book book = Book.builder()
                .id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
                .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build();
        BookDto bookDto = bookMapper.toBookDto(book);

        System.out.println(gson.toJson(bookDto));
    }

    @Test
    @DisplayName("Mapper 테스트 : BookDto -> Book")
    public void checkMapperBookDtoToBook() {
        BookDto bookDto = BookDto.builder()
                .id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
                .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build();
        Book book = bookMapper.toBook(bookDto);

        System.out.println(gson.toJson(book));
    }

    @Test
    @DisplayName("Mapper 테스트 : Book -> BookEntity")
    public void checkMapperBookToBookEntity() {
        Book book = Book.builder()
                .id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
                .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build();
        BookEntity bookEntity = bookMapper.toBookEntity(book);

        System.out.println(gson.toJson(bookEntity));
    }

    @Test
    @DisplayName("Mapper 테스트 : BookEntity -> Book")
    public void checkMapperBookEntityToBook() {
        BookEntity bookEntity = BookEntity.builder()
                .id(1L).ISBN(9788936433598L).title("채식주의자").author("한강").publisher("창비")
                .publishDate(Date.valueOf(LocalDate.of(2007, 10, 30)))
                .price(35000).inventory(new Inventory(5)).build();
        Book book = bookMapper.toBook(bookEntity);

        System.out.println(gson.toJson(book));
    }
}