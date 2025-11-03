package com.example.demo.controller;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Showw;
import com.example.demo.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ConcertController {
    @Autowired
    ConcertService concertService;

    /**
     *
     * @param concert
     * @return  Concert
     */
    @PostMapping("/addconcert")
    public Concert addConcert(@RequestBody Concert concert){
        return concertService.addConcert(concert);
    }


    @GetMapping("/getconcertsbydescription/{description}")
    public List<Concert> getConcertsByDescription(@PathVariable String description){
        return concertService.getconcertsbydescription(description);
    }

    @GetMapping("/longestconcerts")
    public List<Concert> getLongestConcert(){
        return concertService.getLongestConcerts();
    }

}
