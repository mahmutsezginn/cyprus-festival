package com.example.demo.controller;


import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Organizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizerControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;


    @Test
    void getOrganizer(){
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getorganiser/irfanalgan@gmail.com", Organizer.class), "Organizer(email=irfanalgan@gmail.com, phoneNo=0, name=irfan kaan, surname=algan)");
    }
}
