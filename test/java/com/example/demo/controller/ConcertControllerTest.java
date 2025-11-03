package com.example.demo.controller;


import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Concert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConcertControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    void getConcertsByDescription() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getconcertsbydescription/aciklama", List.class), "[{eventID=1, eventName=Fikri Konser, date=null, duration=3.0, description=aciklama, festivalRun=null, performer=Fikri Karayel}]");
    }
}

