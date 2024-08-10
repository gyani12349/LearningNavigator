package com.example.learningnavigator.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class examDTO {

    private Long id;
    private Long subjectId;
    private List<Long> studentIds;
}
