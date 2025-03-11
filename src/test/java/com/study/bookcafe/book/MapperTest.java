package com.study.bookcafe.book;

import com.google.gson.Gson;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import com.study.bookcafe.infrastructure.query.book.BookTestSets;
import com.study.bookcafe.interfaces.book.BookInventoryDto;
import com.study.bookcafe.interfaces.common.JsonHelper;
import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.interfaces.book.BookDto;
import com.study.bookcafe.interfaces.book.BookMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

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

    @Test
    @DisplayName("Mapper 테스트 : BookInventory -> BookInventoryDto")
    public void checkMapperBookInventoryToBookInventoryDto() {
        BookInventoryDto bookInventoryDto = bookMapper.toBookInventoryDto(BookTestSets.VEGETARIAN_BOOK_INVENTORY);
        assertThat(bookInventoryDto).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BookInventoryDto -> BookInventory")
    public void checkMapperBookInventoryDtoToBookInventory() {
        BookInventory bookInventory = bookMapper.toBookInventory(BookTestSets.VEGETARIAN_BOOK_INVENTORY_DTO);
        assertThat(bookInventory).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BookInventory -> BookInventoryEntity")
    public void checkMapperBookInventoryToBookInventoryEntity() {
        BookInventoryEntity bookInventoryEntity = bookMapper.toBookInventoryEntity(BookTestSets.VEGETARIAN_BOOK_INVENTORY);
        assertThat(bookInventoryEntity).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : BookInventoryEntity -> BookInventory")
    public void checkMapperBookInventoryEntityToBookInventory() {
        BookInventory bookInventory = bookMapper.toBookInventory(BookTestSets.VEGETARIAN_BOOK_INVENTORY_ENTITY);
        assertThat(bookInventory).isNotNull();
    }

}
