package com.example.demo.service;

import com.example.demo.entity.Festival;
import com.example.demo.repository.FestivalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FestivalServiceTest {
    @InjectMocks
    FestivalService festivalService;

    @Mock
    FestivalRepository festivalRepository;

    @Test
    void getFestivals(){
        ArrayList<Festival> festivals = new ArrayList<>();
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));

        when(festivalRepository.findAll()).thenReturn(festivals);

        List<Festival> festivalList = festivalService.getFestivals();
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("girne",festivalList.get(0).getPlace());
    }

    @Test
    void getFestival(){
        List<Festival> festivals = new ArrayList<>();
        Festival festival;
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        long festivalID = 1;

        doReturn(Optional.of(festivals.get(0))).when(festivalRepository).findById(festivalID);

        festival = festivalService.getFestival(festivalID);
        Assertions.assertEquals(festivals.get(0).getPlace(),festival.getPlace());
        Assertions.assertEquals(festivals.get(0).getFestivalName(),festival.getFestivalName());
        Assertions.assertEquals(festival,festivals.get(0));

    }
    @Test
    void getFestivalsForACity(){
        /***********************************************************************************************************************/
        ArrayList<Festival> festivals = new ArrayList<>();
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"girne","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        String place = "lefke";


        when(festivalRepository.findByplaceContains(place)).thenReturn(festivals);
        List<Festival> festivalList = festivalService.getFestivalsForACity(place);
        System.out.println(festivalList);
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("girne",festivalList.get(0).getPlace());

    }

    @Test
    void getFestivalbyName(){
        List<Festival> festivals = new ArrayList<>();
        Festival festival;
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        String festivalName = "portakal";

        when(festivalRepository.getFestivalByName(festivalName)).thenReturn(festivals);


        List<Festival> festivalList = festivalService.getFestivalbyName(festivalName);
        System.out.println(festivalList);
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("portakal",festivalList.get(0).getFestivalName());

    }
}
