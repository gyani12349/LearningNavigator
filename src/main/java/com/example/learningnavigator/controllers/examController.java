package com.example.learningnavigator.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.learningnavigator.services.*;
import com.example.learningnavigator.entities.exam;
import com.example.learningnavigator.entities.student;

@RestController
@RequestMapping("/exams")
public class examController {

    @Autowired
    private examService examService;

    @GetMapping
    public ResponseEntity<List<exam>> getAllExams() {
        List<exam> exams = examService.getAllExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @PostMapping("/{examId}")
    public ResponseEntity<exam> registerStudentForExam(@PathVariable Long examId, @RequestBody student student) {
        exam registeredExam = examService.registerStudentForExam(examId, student);
        return new ResponseEntity<>(registeredExam, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
