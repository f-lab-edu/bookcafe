package com.study.bookcafe.dao;

import com.study.bookcafe.entity.Level;
import com.study.bookcafe.dto.MemberDTO;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class GeneralMemberDAO implements MemberDAO {

    Map<Long, MemberDTO> members = new HashMap<>(){{
        put(1L, MemberDTO.builder().memberId(1L).memberName("슈카").level(Level.BASIC).borrowCount(0).build());
        put(2L, MemberDTO.builder().memberId(2L).memberName("머스크").level(Level.WORM).borrowCount(3).build());
        put(3L, MemberDTO.builder().memberId(3L).memberName("트럼프").level(Level.LIBRARIAN).borrowCount(5).build());
    }};

    @Override
    public MemberDTO findById(long memberId) {
        // 추후 DB 연결 후 재작성
        return members.get(memberId);
    }
}
