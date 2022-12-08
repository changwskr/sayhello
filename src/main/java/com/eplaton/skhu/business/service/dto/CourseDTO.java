package com.eplaton.skhu.business.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    int id;
    String courseName;
    int departmentId;
    int unit;
    int professorId;
    Date startDate;
//    String professorName;
//    int professorDepartmentId;
    ProfessorDTO professor;

}
