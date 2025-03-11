package com.study.bookcafe.interfaces.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.infrastructure.query.borrow.BorrowEntity;
import com.study.bookcafe.interfaces.book.BookMapper;
import com.study.bookcafe.interfaces.member.MemberMapper;
import jdk.jfr.Name;
import org.mapstruct.*;

import java.util.List;

@Named("BorrowMapper")
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MemberMapper.class, BookMapper.class}
)
public interface BorrowMapper {

    // Borrow -> BorrowDto
    @Named("BorrowToBorrowDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberDto"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryToBookInventoryDto"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod")
    @Mapping(target = "extensionCount", source = "extensionCount")
    BorrowDto toBorrowDto(Borrow borrow);

    // BorrowDto -> Borrow
    @Name("BorrowDtoToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberDtoToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryDtoToBookInventory"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod")
    @Mapping(target = "extensionCount", source = "extensionCount")
    Borrow toBorrow(BorrowDto borrowDto);

    // Borrow -> BorrowEntity
    @Named("BorrowToBorrowEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryToBookInventoryEntity"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod")
    @Mapping(target = "extensionCount", source = "extensionCount")
    BorrowEntity toBorrowEntity(Borrow borrow);

    // BorrowEntity -> Borrow
    @Named("BorrowEntityToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberEntityToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryEntityToBookInventory"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "borrowPeriod", source = "borrowPeriod")
    @Mapping(target = "extensionCount", source = "extensionCount")
    Borrow toBorrow(BorrowEntity borrowEntity);

    // List<Borrow> -> List<BorrowEntity>
    @IterableMapping(qualifiedByName = "BorrowToBorrowEntity")
    List<BorrowEntity> toBorrowEntities(List<Borrow> borrows);

    // List<BorrowEntity> -> List<Borrow>
    @IterableMapping(qualifiedByName = "BorrowEntityToBorrow")
    List<Borrow> toBorrows(List<BorrowEntity> borrowEntities);

    // List<Borrow> -> List<BorrowDto>
    @IterableMapping(qualifiedByName = "BorrowToBorrowDto")
    List<BorrowDto> toBorrowDtos(List<Borrow> borrows);


}
