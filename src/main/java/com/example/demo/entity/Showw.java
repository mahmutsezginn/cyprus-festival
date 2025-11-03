package com.example.demo.entity;


import lombok.Data;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Showw extends Event{
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Performer> performers;

}