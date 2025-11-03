package com.example.demo.controller;

import com.example.demo.entity.OrganizedFestivalRun;
import com.example.demo.service.OrganizedFestivalRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizedFestivalRunController {
    @Autowired
    OrganizedFestivalRunService organizedFestivalRunService;


}
