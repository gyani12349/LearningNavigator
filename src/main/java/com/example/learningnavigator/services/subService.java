package com.example.learningnavigator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.learningnavigator.repositories.*;
import com.example.learningnavigator.entities.*;

@Service
public class subService {

    @Autowired
    private subRepo subjectRepository;

    public List<sub> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public sub createSubject(sub subject) {
        return subjectRepository.save(subject);
    }

}
