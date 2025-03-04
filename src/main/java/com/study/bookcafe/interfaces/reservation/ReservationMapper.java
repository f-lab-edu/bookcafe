package com.study.bookcafe.interfaces.reservation;

import com.study.bookcafe.domain.reservation.Reservation;
import com.study.bookcafe.infrastructure.query.reservation.ReservationEntity;
import com.study.bookcafe.interfaces.book.BookMapper;
import com.study.bookcafe.interfaces.member.MemberMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Named("ReservationMapper")
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MemberMapper.class, BookMapper.class}
)
public interface ReservationMapper {
    @Named("ReservationEntityToReservation")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "book", source = "book")
    @Mapping(target = "time", source = "time")
    // ReservationEntity -> Reservation
    Reservation toReservation(ReservationEntity reservationEntity);

    @Named("ReservationToReservationEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "book", source = "book")
    @Mapping(target = "time", source = "time")
    // Reservation -> ReservationEntity
    ReservationEntity toReservationEntity(Reservation reservation);
}
