package com.study.bookcafe.interfaces.borrow;

import com.study.bookcafe.domain.borrow.Borrow;
import com.study.bookcafe.domain.borrow.Reservation;
import com.study.bookcafe.infrastructure.command.borrow.ReservationEntity;
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

    @Named("BorrowToBorrowDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberDto"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookToBookDto"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "period", source = "period")
    // Borrow -> BorrowDto
    BorrowDto toBorrowDto(Borrow borrow);

    @Name("BorrowDtoToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberDtoToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookDtoToBook"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "period", source = "period")
    // BorrowDto -> Borrow
    Borrow toBorrow(BorrowDto borrowDto);

    @Named("BorrowToBorrowEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookToBookEntity"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "period", source = "period")
    // Borrow -> BorrowEntity
    BorrowEntity toBorrowEntity(Borrow borrow);

    @Named("BorrowEntityToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberEntityToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookEntityToBook"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "period", source = "period")
    // BorrowEntity -> Borrow
    Borrow toBorrow(BorrowEntity borrowEntity);

    @IterableMapping(qualifiedByName = "BorrowToBorrowEntity")
    // List<Borrow> -> List<BorrowEntity>
    List<BorrowEntity> toBorrowEntities(List<Borrow> borrows);

    @IterableMapping(qualifiedByName = "BorrowEntityToBorrow")
    // List<BorrowEntity> -> List<Borrow>
    List<Borrow> toBorrows(List<BorrowEntity> borrowEntities);

    @IterableMapping(qualifiedByName = "BorrowToBorrowDto")
    // List<Borrow> -> List<BorrowDto>
    List<BorrowDto> toBorrowDtos(List<Borrow> borrows);

    @Named("ReservationEntityToReservation")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "memberId", source = "memberId")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "time", source = "time")
    // ReservationEntity -> Reservation
    Reservation toReservation(ReservationEntity reservationEntity);

    @Named("ReservationToReservationEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "memberId", source = "memberId")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "time", source = "time")
    // Reservation -> ReservationEntity
    ReservationEntity toReservationEntity(Reservation reservation);
}
