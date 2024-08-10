package com.example.learningnavigator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.learningnavigator.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<student, Long> {

}
