package com.bharat.FilterPractice02.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String subject;
}
