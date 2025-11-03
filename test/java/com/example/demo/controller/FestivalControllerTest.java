package com.example.demo.controller;

import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Festival;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FestivalControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;


    @Test
    void getFestivals() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getallfestivals", List.class), "[{festivalID=1, place=girne, festivalName=portakal, festivalRunList=[]}," +
                                                                                                                            " {festivalID=2, place=lefke, festivalName=elma, festivalRunList=[]}," +
                                                                                                                            " {festivalID=3, place=gyurt, festivalName=limon, festivalRunList=[]}]");
    }

    @Test
    void getFestival() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getfestival/1", Festival.class), "Festival{festivalID=1, place='girne', festivalName='portakal', festivalRunList=[]}");

    }

    @Test
    void getFestivalbyName(){
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getFestivalsbyname/Portakal", List.class), "[{festivalID=1, place=girne, festivalName=portakal, festivalRunList=[]}]");
    }
}
