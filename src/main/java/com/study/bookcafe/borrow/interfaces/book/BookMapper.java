package com.study.bookcafe.borrow.interfaces.book;

import com.study.bookcafe.borrow.domain.book.BookInventory;
import com.study.bookcafe.borrow.infrastructure.query.book.BookInventoryEntity;
import org.mapstruct.*;

@Named("BookMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, implementationName = "borrowContextBookMapperImpl")
public interface BookMapper {

    // BookInventory -> BookInventoryEntity
    @Named("BookInventoryToBookInventoryEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventoryEntity toBookInventoryEntity(BookInventory bookInventory);

    // BookInventoryEntity -> BookInventory
    @Named("BookInventoryEntityToBookInventory")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "borrowedCount", source = "borrowedCount")
    @Mapping(target = "reservedCount", source = "reservedCount")
    @Mapping(target = "priorityBorrowCount", source = "priorityBorrowCount")
    BookInventory toBookInventory(BookInventoryEntity bookInventoryEntity);
}
