package com.example.demo.repository;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, String> {
    public List<Organizer> findByEmailStartingWithOrNameOrPhoneNoOrSurname(String email,String name,int phoneNo,String surname);

}
