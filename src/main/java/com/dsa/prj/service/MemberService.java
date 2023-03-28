package com.dsa.prj.service;

import com.dsa.prj.aop.CommonException;
import com.dsa.prj.common.CommonCode;
import com.dsa.prj.domain.Member;
import com.dsa.prj.dto.MemberDTO;
import com.dsa.prj.repositories.MemberRepository;
import com.dsa.prj.vo.MemberFindParams;
import com.dsa.prj.vo.MemberJoinParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    private MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberDTO> getAllMemeberList() {

        return memberRepository.findAll().stream()
                .map(MemberDTO::getDto)
                .collect(Collectors.toList());
    }

    public MemberDTO getMemberDetail(String memberId) throws Exception {
        Optional<Member> member = memberRepository.findByMemId(memberId);

        return MemberDTO.getDto(member.orElseThrow(() -> new CommonException(CommonCode.NOT_FOUND.getCode(), CommonCode.NOT_FOUND.getMessage())));
    }

    /**
     * 회원 ID 찾기
     * @param memberFindParams
     * @return
     * @throws CommonException
     */
    public String findMemberId(MemberFindParams memberFindParams) throws CommonException {
        if (ObjectUtils.isEmpty(memberFindParams.getMemberEmail())) {
            throw new CommonException(400, "이메일 주소가 잘못되었습니다");
        }

        if (ObjectUtils.isEmpty(memberFindParams.getMemberName())) {
            throw new CommonException(400, "이름이 잘못되었습니다.");
        }

        return memberRepository.findByMemMailAndMemName(memberFindParams.getMemberEmail(), memberFindParams.getMemberName())
                .orElseThrow(()-> new CommonException(CommonCode.NOT_FOUND.getCode(), CommonCode.NOT_FOUND.getMessage()))
                .getMemId();

    }


    /**
     * 회원가입
     * @param memberJoinParams
     * @throws CommonException
     */
    public void joinMember(MemberJoinParams memberJoinParams) throws CommonException {

        if (ObjectUtils.isEmpty(memberJoinParams.getRequestName())) {
            throw new CommonException(CommonCode.NOT_FOUND.getCode(), "이름 데이터가 잘못되었습니다");
        }

        if (ObjectUtils.isEmpty(memberJoinParams.getRequestId())) {
            throw new CommonException(CommonCode.NOT_FOUND.getCode(), "ID 데이터가 잘못되었습니다");
        }

        if (ObjectUtils.isEmpty(memberJoinParams.getRequestEmail())) {
            throw new CommonException(CommonCode.NOT_FOUND.getCode(), "이메일 데이터가 잘못되었습니다");
        }

        if (ObjectUtils.isEmpty(memberJoinParams.getRequestPhoneNumber())) {
            throw new CommonException(CommonCode.NOT_FOUND.getCode(), "전화번호 데이터가 잘못되었습니다");
        }

        if (memberRepository.findByMemId(memberJoinParams.getRequestId()).isPresent()) {
            throw new CommonException(CommonCode.DUPLICATED_DATA.getCode(), "ID가 중복되었습니다");
        }

        if (memberRepository.findByMemMail(memberJoinParams.getRequestEmail()).isPresent()) {
            throw new CommonException(CommonCode.DUPLICATED_DATA.getCode(), "메일이 중복되었습니다");
        }

        if (memberRepository.findByMemPhone(memberJoinParams.getRequestPhoneNumber()).isPresent()) {
            throw new CommonException(CommonCode.DUPLICATED_DATA.getCode(), "전화번호가 중복되었습니다");
        }


        Member member = Member.builder()
                .memId(memberJoinParams.getRequestId())
                .memName(memberJoinParams.getRequestName())
                .memMail(memberJoinParams.getRequestEmail())
                .memPassword(memberJoinParams.getPassWord())
                .memPhone(memberJoinParams.getRequestPhoneNumber())
                .createDate(LocalDateTime.now())
                .build();

        memberRepository.save(member);
    }


}
