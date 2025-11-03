package com.example.demo.service;

import com.example.demo.entity.OrganizedFestivalRun;
import com.example.demo.repository.OrganizedFestivalRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizedFestivalRunService {
    @Autowired
    OrganizedFestivalRunRepository organizedFestivalRunRepository;

    /**
     *
     * @param organizedFestivalRun
     * @return  OrganizedFestivalRun
     */
    public OrganizedFestivalRun addOrganizedFestivalRun(OrganizedFestivalRun organizedFestivalRun){
        return organizedFestivalRunRepository.save(organizedFestivalRun);
    }

}
