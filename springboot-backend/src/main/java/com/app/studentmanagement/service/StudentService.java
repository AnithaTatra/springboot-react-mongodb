package com.app.studentmanagement.service;

import com.app.studentmanagement.dto.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    Student createStudentWithData(Student student);
    List<Student> getAllStudentDetails();
    Optional<Student> getOneStudentDataById(long id);
   ResponseEntity<Student> modifyStudentDataById(long id,Student updatedStudent);
    ResponseEntity<Map<String, Boolean>> deleteStudentDataById(long id);
}
