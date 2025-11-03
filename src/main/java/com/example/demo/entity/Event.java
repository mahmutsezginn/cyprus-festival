package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eventID")
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long eventID;
    private String eventName;
    private Date date;
    private int duration;
    private String description;

    @ManyToOne
    private FestivalRun festivalRun;

    public long getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getDate() {
        return date;
    }

    public double getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public FestivalRun getFestivalRun() {
        return festivalRun;
    }
}
