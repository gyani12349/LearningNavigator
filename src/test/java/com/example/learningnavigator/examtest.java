package com.example.learningnavigator;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.learningnavigator.entities.exam;
import com.example.learningnavigator.repositories.examRepo;
import com.example.learningnavigator.services.examService;

@RunWith(MockitoJUnitRunner.class)
public class examtest {

    @Mock
    private examRepo examRepository;

    @InjectMocks
    private examService examService;

    @Test
    public void testGetExamById() {
       
        Long examId = 1L;
        exam exam = new exam();
        exam.setId(examId);
    }

}
