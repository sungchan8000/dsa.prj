package com.dsa.prj.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_MEMBER_MST")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_mst_seq")
    private Long memMstSeq;

    @Column(name = "mem_name")
    private String memName;

    @Column(name = "mem_id")
    private String memId;

    @Column(name = "mem_phone")
    private String memPhone;

    @Column(name = "mem_mail")
    private String memMail;

    @Column(name = "mem_password")
    private String memPassword;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;


}
