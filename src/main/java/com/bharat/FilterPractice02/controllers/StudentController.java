package com.bharat.FilterPractice02.controllers;

import com.bharat.FilterPractice02.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/details")
    public Student getStudentDetails(){
        return Student.builder()
                .firstName("Bharat")
                .lastName("Maheshwari")
                .subject("CS?")
                .build();
    }
}
