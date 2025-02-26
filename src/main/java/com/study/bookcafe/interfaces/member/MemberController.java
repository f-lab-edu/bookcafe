package com.study.bookcafe.interfaces.member;

import com.study.bookcafe.application.query.member.MemberQueryService;
import com.study.bookcafe.domain.member.Member;
import com.study.bookcafe.interfaces.borrow.BorrowMapper;
import com.study.bookcafe.application.command.member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService memberService;
    private final MemberQueryService memberQueryService;
    private final MemberMapper memberMapper;
    private final BorrowMapper borrowMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper, BorrowMapper borrowMapper, MemberQueryService memberQueryService) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.borrowMapper = borrowMapper;
        this.memberQueryService = memberQueryService;
    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity<MemberDto> member(@PathVariable long id) {
        Member member = memberQueryService.findById(id);
        return ResponseEntity.ok(memberMapper.toMemberDto(member));
    }
}
