package com.example.demo.service;


import com.example.demo.entity.OtherActivity;
import com.example.demo.entity.Showw;
import com.example.demo.repository.OtherActivityRepository;
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
public class OtherActivityServiceTest {
    @InjectMocks
    OtherActivityService otherActivityService;
    @Mock
    OtherActivityRepository otherActivityRepository;

    @Test
    void getOtherActivity(){
        ArrayList<OtherActivity> otherActivities = new ArrayList<>();
        OtherActivity otherActivity1 = new OtherActivity();
        OtherActivity otherActivity2 = new OtherActivity();
        otherActivity1.setEventName("Summit");
        otherActivity1.setDescription("Ethereum Summit");
        otherActivity1.setDate(null);
        otherActivity1.setDuration(3);
        otherActivities.add(otherActivity1);
        otherActivity2.setEventName("Summit2");
        otherActivity2.setDescription("Bitcoin Summit2");
        otherActivity2.setDate(null);
        otherActivity2.setDuration(2);
        otherActivities.add(otherActivity2);
        long eventID = 1;

        doReturn(Optional.of(otherActivity1)).when(otherActivityRepository).findById(eventID);

        OtherActivity otherActivity = otherActivityService.getOtherActivity(eventID);
        Assertions.assertEquals(otherActivity1.getEventName(),otherActivity.getEventName());
        Assertions.assertEquals(otherActivity1.getDescription(),otherActivity.getDescription());
        Assertions.assertEquals(otherActivity1.getDuration(),otherActivity.getDuration());
    }

    @Test
    void getOtherActivities(){
        ArrayList<OtherActivity> otherActivities = new ArrayList<>();
        OtherActivity otherActivity1 = new OtherActivity();
        OtherActivity otherActivity2 = new OtherActivity();
        otherActivity1.setEventName("Summit");
        otherActivity1.setDescription("Ethereum Summit");
        otherActivity1.setDate(null);
        otherActivity1.setDuration(3);
        otherActivities.add(otherActivity1);
        otherActivity2.setEventName("Summit2");
        otherActivity2.setDescription("Bitcoin Summit2");
        otherActivity2.setDate(null);
        otherActivity2.setDuration(2);
        otherActivities.add(otherActivity2);
        List<OtherActivity> otherActivities1 = new ArrayList<>();
        otherActivities1.add(otherActivity1);
        otherActivities1.add(otherActivity2);

        when(otherActivityRepository.findAll()).thenReturn(otherActivities1);
        List<OtherActivity> otherActivities2 = otherActivityService.getOtherActivities();
        Assertions.assertEquals(otherActivities1.get(0).getEventName(),otherActivities2.get(0).getEventName());
        Assertions.assertEquals(otherActivities1.get(0).getDescription(),otherActivities2.get(0).getDescription());
        Assertions.assertEquals(otherActivities1.get(0).getDuration(),otherActivities2.get(0).getDuration());
    }
}
