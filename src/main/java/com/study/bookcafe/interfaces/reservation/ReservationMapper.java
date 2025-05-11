package com.study.bookcafe.interfaces.reservation;

import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.infrastructure.query.reservation.ReservationEntity;
import com.study.bookcafe.interfaces.book.BookMapper;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Named("ReservationMapper")
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MemberMapper.class, BookMapper.class, BorrowMapper.class}
)
public interface ReservationMapper {
    // ReservationEntity -> Reservation
    @Named("ReservationEntityToReservation")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberEntityToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryEntityToBookInventory"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "priorityBorrowPeriod", source = "priorityBorrowPeriod", qualifiedByName = {"BorrowMapper", "PriorityBorrowPeriodEntityToPriorityBorrowPeriod"})
    Reservation toReservation(ReservationEntity reservationEntity);

    // Reservation -> ReservationEntity
    @Named("ReservationToReservationEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookInventoryToBookInventoryEntity"})
    @Mapping(target = "time", source = "time")
    @Mapping(target = "priorityBorrowPeriod", source = "priorityBorrowPeriod", qualifiedByName = {"BorrowMapper", "PriorityBorrowPeriodToPriorityBorrowPeriodEntity"})
    ReservationEntity toReservationEntity(Reservation reservation);
}
