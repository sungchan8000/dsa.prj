package com.dsa.prj.dto;

import com.dsa.prj.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class EventDTO {

    private Long eveMstSeq;

    private String eveId;

    private String eveName;

    private String eveDesc;

    private int eveMinCapacity;

    private int eveMaxCapacity;

    private String eveDateYear;

    private LocalDateTime startSignDate;

    private LocalDateTime endSignDate;

    private boolean eventFlag;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;


    public static EventDTO getEventDto(Event event) {
        return EventDTO.builder()
                .eveMstSeq(event.getEveMstSeq())
                .eveId(event.getEveId())
                .eveName(event.getEveName())
                .eveDesc(event.getEveDesc())
                .eveMinCapacity(event.getEveMinCapacity())
                .eveMaxCapacity(event.getEveMaxCapacity())
                .eveDateYear(event.getEveDateYear())
                .startSignDate(event.getStartSignDate())
                .endSignDate(event.getEndSignDate())
                .eventFlag(event.isEventFlag())
                .createDate(event.getCreateDate())
                .modifyDate(event.getModifyDate())
                .build();
    }


}
