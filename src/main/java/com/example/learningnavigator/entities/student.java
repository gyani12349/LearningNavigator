package com.example.learningnavigator.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
@Table(name="STUDENT")

public class student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String registrationId;
    
    private String name;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_subject",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<sub> enrolledsubs;
    
    @ManyToMany(mappedBy = "registeredStudents")
    private List<exam> registeredExams;

    public void registerForExam(exam exam) {
        registeredExams.add(exam);
        exam.getRegisteredStudents().add(this);
    }

    public void addEnrolledsub(sub subject) {
        if (enrolledsubs == null) {
            enrolledsubs = new ArrayList<>();
        }
        enrolledsubs.add(subject);
        subject.getEnrolledStudents().add(this);
    }

}