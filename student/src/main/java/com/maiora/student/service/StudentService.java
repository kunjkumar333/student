package com.maiora.student.service;

import com.maiora.student.dto.CreateStudentRequest;
import com.maiora.student.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(CreateStudentRequest createStudentRequest);

    List<Student> getStudentByAge(int minAge, int maxAge);

    String updateStudent(Long id);

    String updateAllStudentAge();
}
