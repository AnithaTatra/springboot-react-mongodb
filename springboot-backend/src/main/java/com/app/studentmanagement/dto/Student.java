package com.app.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String teacher;

    private String age;

}