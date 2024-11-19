package com.maiora.student.controller;

import com.maiora.student.dto.CreateStudentRequest;
import com.maiora.student.model.Student;
import com.maiora.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/student")
    public String createStudent(@RequestBody CreateStudentRequest createStudentRequest){
       Student student = studentService.createStudent(createStudentRequest);
       return "Student created successfully with id: " + student.getId();
    }

    @GetMapping(value = "/students/age-range")
    public List<Student> getStudent(@RequestParam int minAge, @RequestParam int maxAge){
        return studentService.getStudentByAge(minAge, maxAge);
    }

    @PutMapping(value = "/student/update-age")
    public String getStudent(@RequestParam int id){
        return studentService.updateStudent((long) id);
    }

    @PutMapping(value = "/students/update-age")
    public String updateAllStudentAge(){
        return studentService.updateAllStudentAge();
    }
}
