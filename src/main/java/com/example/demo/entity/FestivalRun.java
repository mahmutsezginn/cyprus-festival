package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "festivalRunID")
public class FestivalRun {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long festivalRunID;
    private int duration;
    private Date date;

    @ManyToOne
    private Festival festival;


    @OneToMany(mappedBy = "festivalRunn", cascade = CascadeType.ALL)
    List<OrganizedFestivalRun> organizedFestivalRunList;

    @OneToMany(mappedBy = "festivalRun", cascade = CascadeType.ALL)
    List<Event> events;




}
