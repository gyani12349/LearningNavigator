package com.example.learningnavigator.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
@Table(name = "EXAM")

public class exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_id", unique = true)
    private String examId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private sub subject;

    @ManyToMany
    @JoinTable(name = "exam_student",
               joinColumns = @JoinColumn(name = "exam_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<student> registeredStudents;
}