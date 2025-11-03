package com.example.demo.service;


import com.example.demo.entity.Performer;
import com.example.demo.entity.Showw;
import com.example.demo.repository.ShowRepository;
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
public class ShowServiceTest {
    @InjectMocks
    ShowService showService;
    @Mock
    ShowRepository showRepository;

    @Test
    void getShow(){
        ArrayList<Showw> shows = new ArrayList<>();
        Showw show = new Showw();
        Showw show1 = new Showw();
        show1.setEventName("concert");
        show1.setDescription("acıklama");
        show1.setPerformers(new ArrayList<>());
        show1.setDate(null);
        show1.setDuration(3);
        shows.add(show1);
        Showw show2 = new Showw();
        show2.setEventName("concert2");
        show2.setDescription("fikriKonser");
        show2.setPerformers(new ArrayList<>());
        show2.setDate(null);
        show2.setDuration(3);
        shows.add(show2);
        long eventID = 1;
        doReturn(Optional.of(show1)).when(showRepository).findById(eventID);

        show = showService.getShow(eventID);
        Assertions.assertEquals(show1.getEventName(),show.getEventName());
        Assertions.assertEquals(show1.getDescription(),show.getDescription());
        Assertions.assertEquals(show1.getDuration(),show.getDuration());
    }

    @Test
    void getShows(){
        ArrayList<Showw> shows = new ArrayList<>();
        Showw show1 = new Showw();
        show1.setEventName("concert");
        show1.setDescription("acıklama");
        show1.setPerformers(new ArrayList<>());
        show1.setDate(null);
        show1.setDuration(3);
        shows.add(show1);
        Showw show2 = new Showw();
        show2.setEventName("concert2");
        show2.setDescription("fikriKonser");
        show2.setPerformers(new ArrayList<>());
        show2.setDate(null);
        show2.setDuration(3);
        shows.add(show2);

        when(showRepository.findAll()).thenReturn(shows);
        List<Showw> showList = showService.getShows();
        Assertions.assertEquals(shows.size(),showList.size());
        Assertions.assertEquals("concert",showList.get(0).getEventName());
    }

    @Test
    void getshowsbyduration(){
        /***********************************************************************************************************************/
        ArrayList<Showw> shows = new ArrayList<>();
        Showw show1 = new Showw();
        show1.setEventName("concert");
        show1.setDescription("acıklama");
        show1.setPerformers(new ArrayList<>());
        show1.setDate(null);
        show1.setDuration(1);
        shows.add(show1);

        Showw show2 = new Showw();
        show2.setEventName("concert2");
        show2.setDescription("fikriKonser");
        show2.setPerformers(new ArrayList<>());
        show2.setDate(null);
        show2.setDuration(3);
        shows.add(show2);

        Showw show3 = new Showw();
        show3.setEventName("concert2");
        show3.setDescription("fikriKonser");
        show3.setPerformers(new ArrayList<>());
        show3.setDate(null);
        show3.setDuration(5);
        shows.add(show3);

        when(showRepository.findBydurationBetween(2,4)).thenReturn(shows);
        List<Showw> showList = showService.getshowsbyduration(2,4);

        Assertions.assertEquals(shows.size(),showList.size());
        Assertions.assertEquals("concert",showList.get(0).getEventName());
    }

    @Test
    void getCrowdedShows(){
        ArrayList<Performer> performers1 = new ArrayList<>();
        Performer performer1 = new Performer();
        performer1.setName("fikri");
        Performer performer2 = new Performer();
        performer1.setName("tarkan");
        performers1.add(performer1);
        performers1.add(performer2);
        ArrayList<Performer> performers2 = new ArrayList<>();
        performers2.add(performer1);


        ArrayList<Showw> shows = new ArrayList<>();
        Showw show1 = new Showw();
        show1.setEventName("concert1");
        show1.setDescription("fikriKonser1");
        show1.setPerformers(performers1);
        show1.setDate(null);
        show1.setDuration(1);
        shows.add(show1);

        Showw show2 = new Showw();
        show2.setEventName("concert2");
        show2.setDescription("fikriKonser2");
        show2.setPerformers(performers2);
        show2.setDate(null);
        show2.setDuration(3);
        shows.add(show2);

        Showw show3 = new Showw();
        show3.setEventName("concert3");
        show3.setDescription("fikriKonser3");
        show3.setPerformers(performers2);
        show3.setDate(null);
        show3.setDuration(5);
        shows.add(show3);

        when(showRepository.findAll()).thenReturn(shows);

        List<Showw> showList = showService.getCrowdedShows();
        System.out.println(showList);
        Assertions.assertEquals(shows.get(0).getPerformers().size(),showList.get(0).getPerformers().size());
        Assertions.assertEquals("concert1",showList.get(0).getEventName());

    }
}
