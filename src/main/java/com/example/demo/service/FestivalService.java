package com.example.demo.service;


import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalService {
    @Autowired
    FestivalRepository festivalRepository;


    /**
     *
     * @param festival
     * @return  festival
     */
    public Festival addFestival(Festival festival){
        return festivalRepository.save(festival);
    }

    /**
     *
     * @param festivalID
     * @return  festival
     */
    public Festival getFestival(long festivalID){
        return festivalRepository.findById(festivalID).orElse(null);
    }

    /**
     *
     * @return  list of festivals
     */
    public List<Festival> getFestivals(){
        return festivalRepository.findAll();
    }

    /**
     *
     * @param festivalID
     * @return  festival
     */
    public List<FestivalRun> getFestivalRunsOfAFestival(long festivalID){
        return festivalRepository.findById(festivalID).get().getFestivalRunList();
    }

    /**
     *
     * @param place
     * @return      list of festivals
     */
    public List<Festival> getFestivalsForACity(String place){
        return festivalRepository.findByplaceContains(place);
    }

    public List<Festival> getFestivalbyName(String festivalName){
        return festivalRepository.getFestivalByName(festivalName);
    }

    public List<Festival> getPopularFestivals(){return festivalRepository.getPopularFestivals();}




}

