package com.maiora.student.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateStudentRequest {
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
}
