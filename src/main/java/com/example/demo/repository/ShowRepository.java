package com.example.demo.repository;

import com.example.demo.entity.Showw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Showw, Long> {

    public List<Showw> findBydurationBetween(int duration1, int duration2);

}
