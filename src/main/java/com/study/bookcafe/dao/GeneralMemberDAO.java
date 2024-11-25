package com.study.bookcafe.dao;

import com.study.bookcafe.dto.Level;
import com.study.bookcafe.dto.MemberDTO;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class GeneralMemberDAO implements MemberDAO {

    Map<Long, MemberDTO> members = new HashMap<>(){{
        put(1L, new MemberDTO("슈카", Level.BASIC, 0));
        put(2L, new MemberDTO("머스크", Level.WORM, 3));
        put(3L, new MemberDTO("트럼프", Level.LIBRARIAN, 5));
    }};

    @Override
    public MemberDTO findById(long memberId) {
        // 추후 DB 연결 후 재작성
        return members.get(memberId);
    }
}
