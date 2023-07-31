package com.app.studentmanagement.controller;

import com.app.studentmanagement.dto.Student;
import com.app.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public Student pushStudentData(@RequestBody Student student){
        return studentService.createStudentWithData(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudentsData() {
        return studentService.getAllStudentDetails();

    }

    @GetMapping("/students/{id}")
  public Optional<Student> getStudentById(@PathVariable  long id){
        return studentService.getOneStudentDataById(id);
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<Student> getUpdatedStudentData(@PathVariable long id, @RequestBody Student student){
        return studentService.modifyStudentDataById(id,student);
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteStudentById(@PathVariable long id) {
        return studentService.deleteStudentDataById(id);
  }
}
