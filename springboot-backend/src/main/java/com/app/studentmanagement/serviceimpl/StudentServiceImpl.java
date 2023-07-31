package com.app.studentmanagement.serviceimpl;

import com.app.studentmanagement.dto.Student;
import com.app.studentmanagement.exception.ResourceNotFoundException;
import com.app.studentmanagement.repository.StudentRepository;
import com.app.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student createStudentWithData(Student student) {
        Optional<Student> saveStudentData = studentRepository.findByEmail(student.getEmailId());
        if(saveStudentData.isPresent()){
            throw new ResourceNotFoundException("Student already exist with given email:" + student.getEmailId());
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getOneStudentDataById(long id) {
        Optional<Student> saveStudentData = studentRepository.findById(id);
        if(saveStudentData.isPresent()) {
            throw new ResourceNotFoundException("Student not exist with id :" + id);
        }
        return studentRepository.findById(id);
    }

    @Override
    public ResponseEntity<Student> modifyStudentDataById(long id,Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmailId(updatedStudent.getEmailId());
        student.setTeacher(updatedStudent.getTeacher());
        student.setAge(updatedStudent.getAge());
        Student studentData = studentRepository.save(student);
        return ResponseEntity.ok(studentData);

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteStudentDataById(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
