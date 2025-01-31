package com.study.bookcafe.book;

import com.google.gson.Gson;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.Inventory;
import com.study.bookcafe.interfaces.book.BookDto;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest {
    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);
    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("Mapper 테스트 : Book -> BookDto")
    public void checkMapperBookToBookDto() {
        BookDto bookDto = bookMapper.toBookDto(BookTestSets.VEGETARIAN_BOOK);
        assertThat(bookDto).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BookDto -> Book")
    public void checkMapperBookDtoToBook() {
        Book book = bookMapper.toBook(BookTestSets.VEGETARIAN_BOOK_DTO);
        assertThat(book).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : Book -> BookEntity")
    public void checkMapperBookToBookEntity() {
        BookEntity bookEntity = bookMapper.toBookEntity(BookTestSets.WHITE_BOOK);
        assertThat(bookEntity).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BookEntity -> Book")
    public void checkMapperBookEntityToBook() {
        Book book = bookMapper.toBook(BookTestSets.WHITE_BOOK_ENTITY);
        assertThat(book).isNotNull();
    }
}
