package com.example.demo.service;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;
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
public class OrganizerServiceTest {
    @InjectMocks
    OrganizerService organizerService;

    @Mock
    OrganizerRepository organizerRepository;

    @Test
    void getOrganizer(){
        List<Organizer> organizers = new ArrayList<>();
        Organizer organizer;
        organizers.add(new Organizer("irfanalgan@gmail.com",533,"irfan kaan","algan"));
        organizers.add(new Organizer("irfan@gmail.com",533,"irfan","algan"));
        organizers.add(new Organizer("kaan@gmail.com",533,"kaan","algan"));
        String organizerId = "irfanalgan@gmail.com";


        doReturn(Optional.of(organizers.get(0))).when(organizerRepository).findById(organizerId);

        organizer = organizerService.getOrganizer(organizerId);
        Assertions.assertEquals(organizers.get(0).getEmail(),organizer.getEmail());
        Assertions.assertEquals(organizers.get(0).getPhoneNo(),organizer.getPhoneNo());
        Assertions.assertEquals(organizers.get(0).getName(),organizer.getName());
        Assertions.assertEquals(organizers.get(0).getSurname(),organizer.getSurname());

    }

    @Test
    void organisersearch(){
        /***********************************************************************************************************************/
        List<Organizer> organizers = new ArrayList<>();
        organizers.add(new Organizer("irfanalgan@gmail.com",533,"irfan kaan","algan"));
        organizers.add(new Organizer("irfan@gmail.com",533,"irfan","algan"));
        organizers.add(new Organizer("kaan@gmail.com",533,"kaan","algan"));
        String email = "irfanalgan@gmail.com";
        String name = "irfan kaan";
        String surname = "algan";
        int phoneNo = 533;


        when(organizerRepository.findByEmailStartingWithOrNameOrPhoneNoOrSurname(surname,email,phoneNo,name)).thenReturn(organizers);

        List<Organizer> organizer = organizerService.organisersearch(email,name,phoneNo,surname);
        System.out.println(organizer);
        Assertions.assertEquals(organizers.get(0).getEmail(),organizer.get(0).getEmail());
        Assertions.assertEquals(organizers.get(0).getPhoneNo(),organizer.get(0).getPhoneNo());
        Assertions.assertEquals(organizers.get(0).getName(),organizer.get(0).getName());
        Assertions.assertEquals(organizers.get(0).getSurname(),organizer.get(0).getSurname());

    }

}
