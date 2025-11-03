package com.example.demo.service;


import com.example.demo.entity.Concert;
import com.example.demo.repository.ConcertRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConcertServiceTest {
    @InjectMocks
    ConcertService concertService;

    @Mock
    ConcertRepository concertRepository;

    @Test
    void getConcert(){
        ArrayList<Concert> concerts = new ArrayList<>();
        Concert concert1 = new Concert();
        Concert concert2 = new Concert();
        concert1.setEventName("concert");
        concert1.setDescription("fikriKonser");
        concert1.setDate(null);
        concert1.setDuration(3);
        concerts.add(concert1);
        concert2.setEventName("concert");
        concert2.setDescription("fikriKonser");
        concert2.setDate(null);
        concert2.setDuration(2);
        concerts.add(concert2);
        long eventID = 1;

        doReturn(Optional.of(concert1)).when(concertRepository).findById(eventID);
        Concert concert = concertService.getConcert(eventID);
        Assertions.assertEquals(concert1.getEventName(),concert.getEventName());
        Assertions.assertEquals(concert1.getDescription(),concert.getDescription());
        Assertions.assertEquals(concert1.getDuration(),concert.getDuration());
    }


    @Test
    void getConcerts(){
        ArrayList<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        concert.setEventName("concert");
        concert.setDescription("acıklama");
        concert.setPerformer("tarkan");
        concert.setDate(null);
        concert.setDuration(3);
        concerts.add(concert);
        Concert concert2 = new Concert();
        concert2.setEventName("concert2");
        concert2.setDescription("fikriKonser");
        concert2.setPerformer("fikri");
        concert2.setDate(null);
        concert2.setDuration(3);
        concerts.add(concert2);

        when(concertRepository.findAll()).thenReturn(concerts);
        List<Concert> concertList = concertService.getConcerts();
        Assertions.assertEquals(concerts.size(),concertList.size());
        Assertions.assertEquals("concert",concertList.get(0).getEventName());
    }

    @Test
    void getconcertsbydescription(){
        /***********************************************************************************************************************/
        ArrayList<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        concert.setEventName("concert");
        concert.setDescription("acıklama");
        concert.setPerformer("tarkan");
        concert.setDate(null);
        concert.setDuration(3);
        concerts.add(concert);
        Concert concert2 = new Concert();
        concert2.setEventName("concert2");
        concert2.setDescription("fikriKonser");
        concert2.setPerformer("fikri");
        concert2.setDate(null);
        concert2.setDuration(3);
        concerts.add(concert2);

        String description = "acıklama";
        when(concertRepository.findBydescriptionContaining(description)).thenReturn(concerts);
        List<Concert> Concerts = concertService.getconcertsbydescription(description);

        Assertions.assertEquals(concerts.get(0).getDescription(),Concerts.get(0).getDescription());
    }

    @Test
    void getLongestConcerts(){
        ArrayList<Concert> concerts = new ArrayList<>();
        Concert concert = new Concert();
        concert.setEventName("concert");
        concert.setDescription("acıklama");
        concert.setPerformer("irfan");
        concert.setDate(null);
        concert.setDuration(3);
        concerts.add(concert);
        Concert concert2 = new Concert();
        concert2.setEventName("concert2");
        concert2.setDescription("fikriKonser");
        concert2.setPerformer("fikri");
        concert2.setDate(null);
        concert2.setDuration(2);
        concerts.add(concert2);

        when(concertRepository.findAll()).thenReturn(concerts);

        List<Concert> Concerts = concertService.getLongestConcerts();
        Assertions.assertEquals(concerts.get(0).getDuration(),Concerts.get(0).getDuration());
    }
}
