package com.example.demo.controller;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import com.example.demo.service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FestivalController {
    @Autowired
    FestivalService festivalService;

    /**
     *
     * @param festival
     * @return  festivalID
     */
    @PostMapping("/addfestival")
    public Festival addFestival(@RequestBody Festival festival){
        return festivalService.addFestival(festival);
    }

    /**
     *
     * @param festivalID
     * @return festival
     */
    @GetMapping("/getfestival/{festivalID}")
    public Festival getFestival(@PathVariable long festivalID){
        return festivalService.getFestival(festivalID);
    }

    /**
     *
     * @return festival
     */
    @GetMapping("/getallfestivals")
    public List<Festival> getFestivals(){
        return festivalService.getFestivals();
    }

    /**
     *
     * @return festival
     */
    @GetMapping("/getfestivalsforacity/{place}")
    public List<Festival> getFestivalsForACity(@PathVariable String place){
        return festivalService.getFestivalsForACity(place);
    }

    /**
     *
     * @return festival
     */
    @GetMapping("/getallfestivalruns/{festivalID}")
    public List<FestivalRun> getFestivalRunsOfAFestival(@PathVariable long festivalID){
        return festivalService.getFestivalRunsOfAFestival(festivalID);
    }

    @GetMapping("/popularfestivals")
    public List<Festival> getPopularFestivals(){
        return festivalService.getPopularFestivals();
    }

    @GetMapping("/getFestivalsbyname/{festivalName}")
    public List<Festival> getFestivalsbyName(@PathVariable String festivalName){
        return festivalService.getFestivalbyName(festivalName);
    }

}
