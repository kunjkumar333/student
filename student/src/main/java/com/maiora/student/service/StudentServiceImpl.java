package com.maiora.student.service;

import com.maiora.student.dto.CreateStudentRequest;
import com.maiora.student.model.Student;
import com.maiora.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = Student.builder()
                .name(createStudentRequest.getName())
                .birthDay(createStudentRequest.getBirthDay())
                .birthMonth(createStudentRequest.getBirthMonth())
                .birthYear(createStudentRequest.getBirthYear())
                .build();
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentByAge(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    @Override
    public String updateStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return "Student is not present";
        }
        updateAge(student.get());
        return "Student age updated successfully";
    }


    @Override
    public String updateAllStudentAge() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            updateAge(student);
        }
        return "All students age updated successfully";
    }

    private void updateAge(Student student) {
        LocalDate date = LocalDate.of(student.getBirthYear(), student.getBirthMonth(), student.getBirthDay());
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - date.getYear();
        student.setAge(age);
        studentRepository.save(student);
    }
}
