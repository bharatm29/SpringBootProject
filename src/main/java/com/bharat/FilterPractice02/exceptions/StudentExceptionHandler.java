package com.bharat.FilterPractice02.exceptions;

import com.bharat.FilterPractice02.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Student> handleStudentException(StudentException studentException){
        return new ResponseEntity<>(Student.builder()
                .firstName("Something went wrong!")
                .lastName("Read the subject for more info")
                .subject(studentException.getMessage())
                .build(), HttpStatus.I_AM_A_TEAPOT);
    }
}
