package com.example.demo.controller;

import com.example.demo.entity.OtherActivity;
import com.example.demo.service.OtherActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherActivityController {
    @Autowired
    OtherActivityService otherActivityService;

    /**
     *
     * @param otherActivity
     * @return  OtherActivity
     */
    @PostMapping("/addotheractivity")
    public OtherActivity addOtherActivity(@RequestBody OtherActivity otherActivity){
        return otherActivityService.addOtherActivity(otherActivity);
    }
}
