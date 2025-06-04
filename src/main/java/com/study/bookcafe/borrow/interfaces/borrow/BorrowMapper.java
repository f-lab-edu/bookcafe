package com.study.bookcafe.borrow.interfaces.borrow;

import com.study.bookcafe.borrow.domain.borrow.Borrow;
import com.study.bookcafe.borrow.domain.borrow.BorrowPeriod;
import com.study.bookcafe.borrow.domain.borrow.DatePeriod;
//import com.study.bookcafe.borrow.domain.borrow.DateTimePeriod;
//import com.study.bookcafe.borrow.domain.borrow.PriorityBorrowPeriod;
import com.study.bookcafe.borrow.infrastructure.query.borrow.*;
import com.study.bookcafe.borrow.infrastructure.query.borrow.BorrowPeriodEntity;
import com.study.bookcafe.borrow.infrastructure.query.borrow.DatePeriodEntity;
import com.study.bookcafe.borrow.interfaces.book.BookMapper;
import com.study.bookcafe.borrow.interfaces.borrower.BorrowerMapper;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Named("borrowBorrowMapper")
@Qualifier("borrowBorrowMapper")
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        implementationName = "borrowContextBorrowMapperImpl",
        uses = {BorrowerMapper.class, BookMapper.class}
)
public interface BorrowMapper {

    // Borrow -> BorrowEntity
    @Named("BorrowToBorrowEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "borrower", source = "borrower", qualifiedByName = {"BorrowerMapper", "BorrowerToBorrowerEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryToBookInventoryEntity"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "returnTime", source = "returnTime")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod", qualifiedByName = {"BorrowPeriodToBorrowPeriodEntity"})
    @Mapping(target = "extensionCount", source = "extensionCount")
    BorrowEntity toBorrowEntity(Borrow borrow);

    // BorrowEntity -> Borrow
    @Named("BorrowEntityToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "borrower", source = "borrower", qualifiedByName = {"BorrowerMapper", "BorrowerEntityToBorrower"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryEntityToBookInventory"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "returnTime", source = "returnTime")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod", qualifiedByName = {"BorrowPeriodEntityToBorrowPeriod"})
    @Mapping(target = "extensionCount", source = "extensionCount")
    Borrow toBorrow(BorrowEntity borrowEntity);

    // List<Borrow> -> List<BorrowEntity>
    @IterableMapping(qualifiedByName = "BorrowToBorrowEntity")
    List<BorrowEntity> toBorrowEntities(List<Borrow> borrows);

    // List<BorrowEntity> -> List<Borrow>
    @IterableMapping(qualifiedByName = "BorrowEntityToBorrow")
    List<Borrow> toBorrows(List<BorrowEntity> borrowEntities);

//    // DateTimePeriod -> DateTimePeriodEntity
//    @Named("DateTimePeriodToDateTimePeriodEntity")
//    @Mapping(target = "from", source = "from")
//    @Mapping(target = "to", source = "to")
//    DateTimePeriodEntity toDateTimePeriodEntity(DateTimePeriod dateTimePeriod);
//
//    // DateTimePeriodEntity -> DateTimePeriod
//    @Named("DateTimePeriodEntityToDateTimePeriod")
//    @Mapping(target = "from", source = "from")
//    @Mapping(target = "to", source = "to")
//    DateTimePeriod toDateTimePeriod(DateTimePeriodEntity dateTimePeriodEntity);

    // DatePeriod -> DatePeriodEntity
    @Named("DatePeriodToDatePeriodEntity")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "to", source = "to")
    DatePeriodEntity toDatePeriodEntity(DatePeriod datePeriod);

    // DatePeriodEntity -> DatePeriod
    @Named("DatePeriodEntityToDatePeriod")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "to", source = "to")
    DatePeriod toDatePeriod(DatePeriodEntity datePeriodEntity);

    // BorrowPeriod -> BorrowPeriodEntity
    @Named("BorrowPeriodToBorrowPeriodEntity")
    @Mapping(target = "period", source = "period")
    @Mapping(target = "level", source = "level")
    BorrowPeriodEntity toBorrowPeriodEntity(BorrowPeriod borrowPeriod);

    // BorrowPeriodEntity -> BorrowPeriod
    @Named("BorrowPeriodEntityToBorrowPeriod")
    @Mapping(target = "period", source = "period")
    @Mapping(target = "level", source = "level")
    BorrowPeriod toBorrowPeriod(BorrowPeriodEntity borrowPeriodEntity);

//    // PriorityBorrowPeriod -> PriorityBorrowPeriodEntity
//    @Named("PriorityBorrowPeriodToPriorityBorrowPeriodEntity")
//    @Mapping(target = "period", source = "period")
//    PriorityBorrowPeriodEntity toPriorityBorrowPeriodEntity(PriorityBorrowPeriod priorityBorrowPeriod);
//
//    // PriorityBorrowPeriodEntity -> PriorityBorrowPeriod
//    @Named("PriorityBorrowPeriodEntityToPriorityBorrowPeriod")
//    @Mapping(target = "period", source = "period")
//    PriorityBorrowPeriod toPriorityBorrowPeriod(PriorityBorrowPeriodEntity priorityBorrowPeriodEntity);

}
