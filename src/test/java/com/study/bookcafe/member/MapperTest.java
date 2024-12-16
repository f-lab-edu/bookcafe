package com.study.bookcafe.member;

import com.google.gson.Gson;
import com.study.bookcafe.common.JsonHelper;
import com.study.bookcafe.domain.Level;
import com.study.bookcafe.domain.Member;
import com.study.bookcafe.dto.MemberDto;
import com.study.bookcafe.entity.MemberEntity;
import com.study.bookcafe.mapper.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest {
    private final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);
    private final Gson gson = JsonHelper.getGson();

    @Test
    @DisplayName("Mapper 테스트 : Member -> MemberDto")
    public void checkMapperMemberToMemberDto() {
        MemberDto memberDto = MemberDto.builder().id(2).name("슈카").level(Level.WORM).borrowCount(5).build();
        Member member = memberMapper.toMember(memberDto);

        assertThat(member).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : MemberDto -> Member")
    public void checkMapperMemberDtoToMember() {
        Member member = Member.builder().id(1).name("김도훈").level(Level.BASIC).borrowCount(2).build();
        MemberDto memberDto = memberMapper.toMemberDto(member);

        assertThat(memberDto).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : Member -> MemberEntity")
    public void checkMapperMemberToMemberEntity() {
        Member member = Member.builder().id(1).name("트럼프").level(Level.LIBRARIAN).borrowCount(7).build();
        MemberEntity memberEntity = memberMapper.toMemberEntity(member);

        assertThat(memberEntity).isNotNull();
    }

    @Test
    @DisplayName("Mapper 테스트 : MemberEntity -> Member")
    public void checkMapperMemberEntityToMember() {
        MemberEntity memberEntity = MemberEntity.builder().id(3).name("머스크").level(Level.WORM).borrowCount(2).build();
        Member member = memberMapper.toMember(memberEntity);

        assertThat(member).isNotNull();
    }
}
