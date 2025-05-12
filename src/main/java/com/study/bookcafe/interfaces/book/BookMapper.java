package com.study.bookcafe.interfaces.book;

import com.study.bookcafe.domain.book.Book;
import com.study.bookcafe.domain.book.BookInventory;
import com.study.bookcafe.infrastructure.query.book.BookEntity;
import com.study.bookcafe.infrastructure.query.book.BookInventoryEntity;
import org.mapstruct.*;

import java.util.List;

@Named("BookMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {


    // BookInventory -> BookInventoryDto
    @Named("BookInventoryToBookInventoryDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookToBookDto"})
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventoryDto toBookInventoryDto(BookInventory bookInventory);

    // BookInventoryDto -> BookInventory
    @Named("BookInventoryDtoToBookInventory")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookDtoToBook"})
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventory toBookInventory(BookInventoryDto bookInventoryDto);

    // BookInventory -> BookInventoryEntity
    @Named("BookInventoryToBookInventoryEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookToBookEntity"})
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventoryEntity toBookInventoryEntity(BookInventory bookInventory);

    // BookInventoryEntity -> BookInventory
    @Named("BookInventoryEntityToBookInventory")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookEntityToBook"})
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventory toBookInventory(BookInventoryEntity bookInventoryEntity);



    // Book -> BookDto
    @Named("BookToBookDto")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "translator", source = "translator")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    BookDto toBookDto(Book book);

    // BookDto -> Book
    @Named("BookDtoToBook")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "translator", source = "translator")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    Book toBook(BookDto bookDto);

    // Book -> BookEntity
    @Named("BookToBookEntity")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "translator", source = "translator")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    BookEntity toBookEntity(Book book);

    // BookEntity -> Book
    @Named("BookEntityToBook")
    @Mapping(target = "ISBN", source = "ISBN")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "translator", source = "translator")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "publishDate", source = "publishDate")
    @Mapping(target = "price", source = "price")
    Book toBook(BookEntity bookEntity);

    // List<BookInventoryEntity> -> List<BookInventory>
    @IterableMapping(qualifiedByName = "BookInventoryEntityToBookInventory")
    List<BookInventory> toBookInventories(List<BookInventoryEntity> bookInventoryEntities);

    // List<BookInventory> -> List<BookInventoryEntity>
    @IterableMapping(qualifiedByName = "BookInventoryToBookInventoryEntity")
    List<BookInventoryEntity> toBookInventoryEntities(List<BookInventory> bookInventories);
}
