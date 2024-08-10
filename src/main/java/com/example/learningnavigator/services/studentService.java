package com.example.learningnavigator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;


import com.example.learningnavigator.repositories.*;
import com.example.learningnavigator.entities.*;

@Service
public class studentService {

    @Autowired
    private studentRepo studentRepository;

    @Autowired
    private subRepo subjectRepository;

    @Autowired
    private examRepo examRepository;

    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    public student createStudent(student student) {
        return studentRepository.save(student);
    }

    public Optional<student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public student updateStudent(Long studentId, student updatedStudent) {
        student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found"));

        existingStudent.setName(updatedStudent.getName());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void registerForExam(Long studentId, Long examId) {

        student student = studentRepository.findById(studentId)
                                           .orElseThrow(() -> new IllegalArgumentException("student not found with ID: " + studentId));
        exam exam = examRepository.findById(examId)
                                   .orElseThrow(() -> new IllegalArgumentException("exam not found with ID: " + examId));

        student.registerForExam(exam);
        studentRepository.save(student);
    }

    public void enrollStudentForSubject(Long studentId, Long subjectId) {
        student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("student not found with ID: " + studentId));
        sub subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with ID: " + subjectId));
        
        student.addEnrolledsub(subject);
        studentRepository.save(student);
    }
}
