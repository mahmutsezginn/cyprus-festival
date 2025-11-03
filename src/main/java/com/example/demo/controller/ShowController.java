package com.example.demo.controller;

import com.example.demo.entity.Showw;
import com.example.demo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    /**
     *
     * @param show
     * @return  show
     */
    @PostMapping("/addshow")
    public Showw addShow(@RequestBody Showw show){
        return showService.addShow(show);
    }
    @GetMapping("/getshowsbyduration")
    public List<Showw> getShowsByDuration(@RequestParam int duration1, @RequestParam int duration2){
        return showService.getshowsbyduration(duration1,duration2);
    }

    @GetMapping("/crowdedshows")
    public List<Showw> getCrowdedShows(){
        return showService.getCrowdedShows();
    }

}
