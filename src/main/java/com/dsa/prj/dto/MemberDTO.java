package com.dsa.prj.dto;

import com.dsa.prj.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class MemberDTO {
    private String memberName;

    private String memberId;

    private String memberPhoneNumber;
    private String memberEmail;

    private LocalDateTime memberCreateTime;

    public static MemberDTO getDto(Member member) {
        return MemberDTO.builder()
                .memberName(member.getMemName())
                .memberId(member.getMemId())
                .memberEmail(member.getMemMail())
                .memberPhoneNumber(member.getMemPhone())
                .memberCreateTime(member.getCreateDate())
                .build();
    }


}
