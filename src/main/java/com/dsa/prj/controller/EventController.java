package com.dsa.prj.controller;

import com.dsa.prj.service.EventService;
import com.dsa.prj.vo.EventJoinParams;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@Slf4j
public class EventController {


    private final EventService eventService;

    private EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/jointest")
    public String test(EventJoinParams eventJoinParams) {

        eventService.joinEvent(eventJoinParams);

        return "sut";
    }
}
