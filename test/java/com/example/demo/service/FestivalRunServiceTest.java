package com.example.demo.service;



import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRunRepository;
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
public class FestivalRunServiceTest {
    @InjectMocks
    FestivalRunService festivalRunService;

    @Mock
    FestivalRunRepository festivalRunRepository;

    @Test
    void getFestivalRun(){
        ArrayList<FestivalRun> festivalRuns = new ArrayList<>();
        FestivalRun festivalRun1 = new FestivalRun();
        FestivalRun festivalRun2 = new FestivalRun();
        festivalRun1.setFestivalRunID(1);
        festivalRun1.setDuration(3);
        festivalRun1.setDate(null);
        festivalRun1.setFestival(null);
        festivalRuns.add(festivalRun1);
        festivalRun2.setFestivalRunID(2);
        festivalRun2.setDuration(2);
        festivalRun2.setDate(null);
        festivalRun2.setFestival(null);
        festivalRuns.add(festivalRun2);
        long festivalRunID = 1;

        doReturn(Optional.of(festivalRun1)).when(festivalRunRepository).findById(festivalRunID);

        FestivalRun festivalRun = festivalRunService.getFestivalRun(festivalRunID);
        Assertions.assertEquals(festivalRun1.getFestivalRunID(),festivalRun.getFestivalRunID());
        Assertions.assertEquals(festivalRun1.getDuration(),festivalRun.getDuration());

    }

    @Test
    void getShortFestivalRun(){
        ArrayList<FestivalRun> festivalRuns = new ArrayList<>();
        FestivalRun festivalRun1 = new FestivalRun();
        FestivalRun festivalRun2 = new FestivalRun();
        FestivalRun festivalRun3 = new FestivalRun();
        festivalRun1.setFestivalRunID(1);
        festivalRun1.setDuration(3);
        festivalRun1.setDate(null);
        festivalRun1.setFestival(null);
        festivalRuns.add(festivalRun1);
        festivalRun2.setFestivalRunID(2);
        festivalRun2.setDuration(2);
        festivalRun2.setDate(null);
        festivalRun2.setFestival(null);
        festivalRuns.add(festivalRun2);
        festivalRun3.setFestivalRunID(3);
        festivalRun3.setDuration(1);
        festivalRun3.setDate(null);
        festivalRun3.setFestival(null);
        festivalRuns.add(festivalRun3);
        int duration = 2;

        when(festivalRunRepository.findBydurationLessThan(duration)).thenReturn(festivalRuns);
        List<FestivalRun> shortFestivalRuns = festivalRunService.getShortFestivalRun(duration);
        Assertions.assertEquals(festivalRuns.size(),shortFestivalRuns.size());
        Assertions.assertEquals(festivalRuns.get(0).getFestivalRunID(),shortFestivalRuns.get(0).getFestivalRunID());
    }
}
