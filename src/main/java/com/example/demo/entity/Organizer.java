
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "email")
public class Organizer {
    @Id
    private String email;
    private int phoneNo;
    private String name;
    private String surname;

//    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
//    List<OrganizedFestivalRun> organizedFestivalRunList;


}
