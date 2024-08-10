package com.example.learningnavigator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.learningnavigator.entities.exam;

@Repository
public interface examRepo extends JpaRepository<exam, Long> {
    
}
