package com.example.learningnavigator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.learningnavigator.services.*;
import com.example.learningnavigator.entities.student;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private studentService studentService;

    @GetMapping
    public ResponseEntity<List<student>> getAllStudents() {
        List<student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<student> getStudentById(@PathVariable Long studentId) {
        Optional<student> student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<student> createStudent(@RequestBody student student) {
        student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<student> updateStudent(@PathVariable Long studentId, @RequestBody student student) {
        student updatedStudent = studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{studentId}/register/{examId}")
    public ResponseEntity<Void> registerForExam(@PathVariable Long studentId, @PathVariable Long examId) {
        studentService.registerForExam(studentId, examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{studentId}/enroll-subject/{subjectId}")
    public ResponseEntity<Void> enrollStudentForsub(@PathVariable Long studentId, @PathVariable Long subjectId) {
        studentService.enrollStudentForSubject(studentId, subjectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
