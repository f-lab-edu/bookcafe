package com.study.bookcafe.interfaces.book;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import org.mapstruct.*;

import java.util.List;

@Named("BookMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Named("BookToBookDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "inventory", source = "inventory")
    // Book -> BookDto
    BookDto toBookDto(Book book);

    @Named("BookDtoToBook")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "inventory", source = "inventory")
    // BookDto -> Book
    Book toBook(BookDto bookDto);

    @Named("BookToBookEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "inventory", source = "inventory")
    // Book -> BookEntity
    BookEntity toBookEntity(Book book);

    @Named("BookEntityToBook")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "inventory", source = "inventory")
    // BookEntity -> Book
    Book toBook(BookEntity bookEntity);

    @IterableMapping(qualifiedByName = "BookEntityToBook")
    // List<BookEntity> -> List<Book>
    List<Book> toBookList(List<BookEntity> bookEntityList);

    @IterableMapping(qualifiedByName = "BookToBookEntity")
    // List<Book> -> List<BookEntity>
    List<BookEntity> toBookEntityList(List<Book> bookList);
}
