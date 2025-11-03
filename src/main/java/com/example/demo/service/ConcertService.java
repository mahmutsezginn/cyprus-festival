package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Showw;
import com.example.demo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcertService {
    @Autowired
    ConcertRepository concertRepository;

    /**
     *
     * @param concert
     * @return  Concert
     */
    public Concert addConcert(Concert concert){
        return concertRepository.save(concert);
    }

    /**
     *
     * @param eventID
     * @return Concert
     */
    public Concert getConcert(long eventID){
        return concertRepository.findById(eventID).orElse(null);
    }

    /**
     *
     * @return  List<Concert>
     */
    public List<Concert> getConcerts(){
        return concertRepository.findAll();
    }

    public List<Concert> getconcertsbydescription(String description){
        return concertRepository.findBydescriptionContaining(description);
    }


    public List<Concert> getLongestConcerts(){
        List<Concert> allConcerts= new ArrayList<>();
        allConcerts = concertRepository.findAll();

        int max=0;

        for(Concert c : allConcerts){
            if(c.getDuration()>max){
                max = (int) c.getDuration();
            }
        }

        List<Concert> longestConcerts = new ArrayList<>();

        for(Concert c: allConcerts){
            if(c.getDuration()==max){
                longestConcerts.add(c);
            }
        }

        return longestConcerts;
    }




}
