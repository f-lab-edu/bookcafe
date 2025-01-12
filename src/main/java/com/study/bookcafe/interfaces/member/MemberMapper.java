package com.study.bookcafe.interfaces.member;

import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.infrastructure.query.member.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

// componentModel : 스프링 컨테이너에 빈으로 등록
// unmappedTargetPolicy : target이 매핑되지 않았을 때 정책
@Named("MemberMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    @Named("MemberToMemberDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    // Member -> MemberDto
    MemberDto toMemberDto(Member member);

    @Named("MemberDtoToMember")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    // MemberDto -> Member
    Member toMember(MemberDto memberDto);

    @Named("MemberToMemberEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    // Member -> MemberEntity
    MemberEntity toMemberEntity(Member member);

    @Named("MemberEntityToMember")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    // MemberEntity -> Member
    Member toMember(MemberEntity memberEntity);
}
