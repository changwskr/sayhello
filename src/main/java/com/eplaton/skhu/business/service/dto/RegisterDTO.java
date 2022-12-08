package com.eplaton.skhu.business.service.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO implements Serializable  {
	
    private static final long serialVersionUID = 1L;
    int id;
    int studentId;
    String StudentNumber;
    String studentName;
    int courseId;
    String courseName;
    int unit;
    int grade;
    Date createDate;
    StudentDTO student;
    CourseDTO course;
  

}
