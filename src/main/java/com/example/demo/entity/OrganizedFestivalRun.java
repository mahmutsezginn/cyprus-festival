package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrganizedFestivalRun {
    @EmbeddedId
    private OrganizedFestivalRunID organizedFestivalRunID;

    @ManyToOne
    @JoinColumn(name = "email", insertable = false, updatable = false)
    Organizer organizer;

    @ManyToOne
    @JoinColumn(name="festivalRunID", insertable = false, updatable = false)
    FestivalRun festivalRunn;


}
