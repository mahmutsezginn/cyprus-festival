package com.example.demo.controller;

import com.example.demo.Cyprusfestival;

import com.example.demo.entity.FestivalRun;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FestivalRunControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    void getFestivalRun() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getfestivalrun/1", FestivalRun.class), "FestivalRun{festivalRunID=1, duration=10,  date=null,festivalID=1}");
       // assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getfestivalrun/1", FestivalRun.class), "Festival{festivalID=1, place='girne', festivalName='portakal', festivalRunList=[]}");

    }

}
