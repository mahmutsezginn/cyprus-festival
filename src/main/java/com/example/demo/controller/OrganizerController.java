package com.example.demo.controller;

import com.example.demo.entity.Organizer;
import com.example.demo.entity.Showw;
import com.example.demo.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;

    /**
     *
     * @param organizer
     * @return  Organizer
     */
    @PostMapping("/addorganiser")
    public Organizer addOrganizer(@RequestBody Organizer organizer){
        return organizerService.addOrganizer(organizer);
    }

    /**
     *
     * @param email
     * @return Organizer
     */
    @GetMapping("/getorganiser/{email}")
    public Organizer getOrganizer(@PathVariable String email){
        return organizerService.getOrganizer(email);
    }

    @GetMapping("/organisersearch")
    public List<Organizer> getShowsByDuration(@RequestParam String name, @RequestParam String surname,@RequestParam int phoneNo,@RequestParam String email){
        return organizerService.organisersearch(name,surname,phoneNo,email);
    }
}



