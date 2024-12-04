package com.study.bookcafe.mapper;

import com.study.bookcafe.domain.Borrow;
import com.study.bookcafe.dto.BorrowDto;
import com.study.bookcafe.entity.BorrowEntity;
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
    @Mapping(target = "borrowDate", source = "borrowDate")
    @Mapping(target = "returnDate", source = "returnDate")
    // Borrow -> BorrowDto
    BorrowDto toBorrowDto(Borrow borrow);

    @Name("BorrowDtoToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberDtoToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookDtoToBook"})
    @Mapping(target = "borrowDate", source = "borrowDate")
    @Mapping(target = "returnDate", source = "returnDate")
    // BorrowDto -> Borrow
    Borrow toBorrow(BorrowDto borrowDto);

    @Named("BorrowToBorrowEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberToMemberEntity"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookToBookEntity"})
    @Mapping(target = "borrowDate", source = "borrowDate")
    @Mapping(target = "returnDate", source = "returnDate")
    // Borrow -> BorrowEntity
    BorrowEntity toBorrowEntity(Borrow borrow);

    @Named("BorrowEntityToBorrow")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "member", source = "member", qualifiedByName = {"MemberMapper", "MemberEntityToMember"})
    @Mapping(target = "book", source = "book", qualifiedByName = {"BookMapper", "BookEntityToBook"})
    @Mapping(target = "borrowDate", source = "borrowDate")
    @Mapping(target = "returnDate", source = "returnDate")
    // BorrowEntity -> Borrow
    Borrow toBorrow(BorrowEntity borrowEntity);

    @IterableMapping(qualifiedByName = "BorrowToBorrowEntity")
    // List<Borrow> -> List<BorrowEntity>
    List<BorrowEntity> toBorrowEntityList(List<Borrow> borrowList);

    @IterableMapping(qualifiedByName = "BorrowEntityToBorrow")
    // List<BorrowEntity> -> List<Borrow>
    List<Borrow> toBorrowList(List<BorrowEntity> borrowEntityList);

    @IterableMapping(qualifiedByName = "BorrowToBorrowDto")
    // List<Borrow> -> List<BorrowDto>
    List<BorrowDto> toBorrowDtoList(List<Borrow> borrowList);
}
