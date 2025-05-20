package com.study.bookcafe.borrow.interfaces.borrow;

import com.study.bookcafe.domain.borrow.*;
import com.study.bookcafe.infrastructure.query.borrow.*;
import org.mapstruct.*;

import java.util.List;

@Named("BorrowMapper")
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BorrowMapper {

    // Borrow -> BorrowEntity
    @Named("BorrowToBorrowEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryToBookInventoryEntity"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod", qualifiedByName = {"BorrowPeriodToBorrowPeriodEntity"})
    @Mapping(target = "extensionCount", source = "extensionCount")
    BorrowEntity toBorrowEntity(Borrow borrow);

    // BorrowEntity -> Borrow
    @Named("BorrowEntityToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberEntityToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryEntityToBookInventory"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod", qualifiedByName = {"BorrowPeriodEntityToBorrowPeriod"})
    @Mapping(target = "extensionCount", source = "extensionCount")
    Borrow toBorrow(BorrowEntity borrowEntity);

    // List<Borrow> -> List<BorrowEntity>
    @IterableMapping(qualifiedByName = "BorrowToBorrowEntity")
    List<BorrowEntity> toBorrowEntities(List<Borrow> borrows);

    // List<BorrowEntity> -> List<Borrow>
    @IterableMapping(qualifiedByName = "BorrowEntityToBorrow")
    List<Borrow> toBorrows(List<BorrowEntity> borrowEntities);

    // DateTimePeriod -> DateTimePeriodEntity
    @Named("DateTimePeriodToDateTimePeriodEntity")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "to", source = "to")
    DateTimePeriodEntity toDateTimePeriodEntity(DateTimePeriod dateTimePeriod);

    // DateTimePeriodEntity -> DateTimePeriod
    @Named("DateTimePeriodEntityToDateTimePeriod")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "to", source = "to")
    DateTimePeriod toDateTimePeriod(DateTimePeriodEntity dateTimePeriodEntity);

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

    // PriorityBorrowPeriod -> PriorityBorrowPeriodEntity
    @Named("PriorityBorrowPeriodToPriorityBorrowPeriodEntity")
    @Mapping(target = "period", source = "period")
    PriorityBorrowPeriodEntity toPriorityBorrowPeriodEntity(PriorityBorrowPeriod priorityBorrowPeriod);

    // PriorityBorrowPeriodEntity -> PriorityBorrowPeriod
    @Named("PriorityBorrowPeriodEntityToPriorityBorrowPeriod")
    @Mapping(target = "period", source = "period")
    PriorityBorrowPeriod toPriorityBorrowPeriod(PriorityBorrowPeriodEntity priorityBorrowPeriodEntity);

}
