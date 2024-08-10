package com.example.learningnavigator.dto;


    import java.util.List;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class subDTO {
    
        private Long id;
        private String name;
        private List<Long> studentIds;
        
    }
