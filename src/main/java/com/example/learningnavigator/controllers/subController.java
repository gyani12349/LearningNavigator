package com.example.learningnavigator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.learningnavigator.services.*;
import com.example.learningnavigator.entities.sub;

@RestController
@RequestMapping("/subjects")
public class subController {

    @Autowired
    private subService subjectService;

    @GetMapping
    public ResponseEntity<List<sub>> getAllsubs() {
        List<sub> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<sub> createsub(@RequestBody sub subject) {
        sub createdsub = subjectService.createSubject(subject);
        return new ResponseEntity<>(createdsub, HttpStatus.CREATED);
    }

    // Other CRUD endpoints for sub entity

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
