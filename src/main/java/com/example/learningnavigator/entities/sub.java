package com.example.learningnavigator.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
@Table(name="SUBJECT")

public class sub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String subjectId;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledsubs")
    private List<student> enrolledStudents;

    @OneToMany(mappedBy = "subject")
    private List<exam> exams;
}