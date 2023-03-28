package com.dsa.prj.service;

import com.dsa.prj.domain.Event;
import com.dsa.prj.repositories.EventRepository;
import com.dsa.prj.vo.EventJoinParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    private EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public void joinEvent(EventJoinParams eventJoinParams) {

        Event event =  Event.builder()
                .eveId(eventJoinParams.getGetId())
                .eveName("test")
                .eveDesc("ttt")
                .eventFlag(eventJoinParams.getEventFlag())
                .eveDateYear(eventJoinParams.getEveDateYear())
                .startSignDate(eventJoinParams.getStartSignDate())
                .endSignDate(eventJoinParams.getEndSignDate())
                .createDate(LocalDateTime.now())
                .build();

        eventRepository.save(event);

    }
}
