package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.query.member.MemberView;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMemberQueryStorage {
    /************************* Command *************************/
    public static Map<Long, Member> members =
            Stream.of(
                    MemberTestSets.BASIC_MEMBER,
                    MemberTestSets.WORM_MEMBER,
                    MemberTestSets.LIBRARIAN_MEMBER
            ).collect(Collectors.toMap(
                    Member::getId,
                    member -> member
            ));

    public static Map<Long, MemberEntity> memberEntities =
            Stream.of(
                    MemberTestSets.BASIC_MEMBER_ENTITY,
                    MemberTestSets.WORM_MEMBER_ENTITY,
                    MemberTestSets.LIBRARIAN_MEMBER_ENTITY
            ).collect(Collectors.toMap(
                    MemberEntity::getId,
                    memberEntity -> memberEntity
            ));

    /************************* Query *************************/
    public static Map<Long, MemberView> memberViews =
            Stream.of(
                    MemberTestSets.BASIC_MEMBER_VIEW,
                    MemberTestSets.WORM_MEMBER_VIEW,
                    MemberTestSets.LIBRARIAN_MEMBER_VIEW
            ).collect(Collectors.toMap(
                    MemberView::getId,
                    memberView -> memberView
            ));
}
