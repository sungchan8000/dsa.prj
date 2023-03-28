package com.dsa.prj.controller;

import com.dsa.prj.aop.CommonException;
import com.dsa.prj.common.ApiResponse;
import com.dsa.prj.common.CommonCode;
import com.dsa.prj.dto.MemberDTO;
import com.dsa.prj.service.MemberService;
import com.dsa.prj.vo.MemberFindParams;
import com.dsa.prj.vo.MemberJoinParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 가입된 멤버 전체 조회한다
     * @return List
     */
    @GetMapping("/members")
    public ApiResponse<List<MemberDTO>> getMembers() {
        return ApiResponse.createSuccess(memberService.getAllMemeberList(), "조회 성공하였습니다.");
    }

    /**
     * 멤버 상세 조회
     */
    @GetMapping("/getDetail/{memberId}")
    public ApiResponse<?> getMember(@PathVariable String memberId) {
        try {
            return ApiResponse.createSuccess(memberService.getMemberDetail(memberId), "조회 성공하였습니다.");
        } catch (Exception ex) {
            return ApiResponse.createError(CommonCode.NOT_FOUND.getCode(),
                                           CommonCode.NOT_FOUND.getMessage());
        }
    }

    @PutMapping("/join")
    public ApiResponse<?> joinMember(MemberJoinParams memberJoinParams) {
        try {
            memberService.joinMember(memberJoinParams);
            return ApiResponse.createSuccessWithNoContent();
        } catch (CommonException commonException) {
            return ApiResponse.createError(commonException);
        }
    }

    @GetMapping("/findMember")
    public ApiResponse<?> findMember(MemberFindParams memberFindParams) {
        try {
            return ApiResponse.createSuccess(memberService.findMemberId(memberFindParams));
        } catch (CommonException commonException) {
            return ApiResponse.createError(commonException);
        }
    }
}
