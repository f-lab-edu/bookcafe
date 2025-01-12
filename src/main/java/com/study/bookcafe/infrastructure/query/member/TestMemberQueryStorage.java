package com.study.bookcafe.infrastructure.query.member;

import com.study.bookcafe.domain.command.member.Member;
import com.study.bookcafe.domain.query.member.MemberView;
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
