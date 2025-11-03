package com.example.demo.repository;

import com.example.demo.entity.Concert;
import com.example.demo.entity.FestivalRun;
import com.example.demo.entity.Showw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    public List<Concert> findBydescriptionContaining(String description);



}

