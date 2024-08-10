package com.example.learningnavigator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.learningnavigator.repositories.*;
import com.example.learningnavigator.entities.*;

@Service
public class examService {

    @Autowired
    private examRepo examRepository;

    public List<exam> getAllExams() {
        return examRepository.findAll();
    }

    public exam registerStudentForExam(Long examId, student student) {
        exam exam = examRepository.findById(examId)
                                  .orElseThrow(() -> new RuntimeException("exam not found"));

        List<student> registeredStudents = exam.getRegisteredStudents();
        registeredStudents.add(student);
        exam.setRegisteredStudents(registeredStudents);

        return examRepository.save(exam);
    }

}
