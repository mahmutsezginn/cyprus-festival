package com.example.demo.service;

import com.example.demo.entity.OtherActivity;
import com.example.demo.repository.OtherActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherActivityService {
    @Autowired
    OtherActivityRepository otherActivityRepository;

    /**
     *
     * @param otherActivity
     * @return  OtherActivity
     */
    public OtherActivity addOtherActivity(OtherActivity otherActivity){
        return otherActivityRepository.save(otherActivity);
    }

    /**
     *
     * @param eventID
     * @return  OtherActivity
     */
    public OtherActivity getOtherActivity(long eventID){
        return otherActivityRepository.findById(eventID).orElse(null);
    }

    /**
     *
     * @return  List<OtherActivity>
     */
    public List<OtherActivity> getOtherActivities(){
        return otherActivityRepository.findAll();
    }
}
