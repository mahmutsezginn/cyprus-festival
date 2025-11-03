package com.example.demo.repository;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
    /**
     *
     * @param place
     * @return  List<Festival>
     */
    public List<Festival> findByplaceContains(String place);

    @Query("SELECT f FROM Festival f WHERE f.festivalName =?1")
    public List<Festival> getFestivalByName(String festivalName);

    @Query(value= "SELECT festivalid,festivalName,place FROM (SELECT festival.festivalid,festival.festivalName,festival.place, COUNT(festivalrun.festival_festivalid) AS numberOfFestivalRuns FROM festivalrun INNER JOIN festival ON festival.festivalid = festivalrun.festival_festivalid GROUP BY festivalrun.festival_festivalid ORDER BY numberOfFestivalRuns ASC) AS asd WHERE numberOfFestivalRuns IN (SELECT MAX(numberOfFestivalRuns) maxNumberOfFestivalRuns FROM (SELECT festival.festivalid, COUNT(festivalrun.festival_festivalid) numberOfFestivalRuns FROM festivalrun INNER JOIN festival ON festival.festivalid = festivalrun.festival_festivalid GROUP BY festivalrun.festival_festivalid) AS occurence);", nativeQuery = true)
    public List<Festival> getPopularFestivals();





}


