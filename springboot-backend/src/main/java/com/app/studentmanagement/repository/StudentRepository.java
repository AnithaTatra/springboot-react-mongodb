package com.app.studentmanagement.repository;

import com.app.studentmanagement.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {

   Optional<Student> findByEmail(String emailId);
}
