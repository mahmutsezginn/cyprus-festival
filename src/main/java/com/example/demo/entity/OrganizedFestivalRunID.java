package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class OrganizedFestivalRunID implements Serializable {
    String email;
    long festivalRunID;
}
