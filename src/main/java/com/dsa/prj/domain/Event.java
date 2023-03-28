package com.dsa.prj.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_EVENT_MST")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVE_MST_SEQ")
    private Long eveMstSeq;

    @Column(name = "EVE_ID")
    private String eveId;

    @Column(name = "EVE_NAME")
    private String eveName;

    @Column(name = "EVE_DESC")
    private String eveDesc;

    @Column(name = "EVE_MIN_CAPACITY")
    private int eveMinCapacity;

    @Column(name = "EVE_MAX_CAPACITY")
    private int eveMaxCapacity;

    @Column(name = "EVE_DATE_YEAR")
    private String eveDateYear;

    @Column(name = "START_SIGN_DATE")
    private LocalDateTime startSignDate;

    @Column(name = "END_SIGN_DATE")
    private LocalDateTime endSignDate;

    @Column(name = "EVENT_FLAG")
    private boolean eventFlag;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

}
