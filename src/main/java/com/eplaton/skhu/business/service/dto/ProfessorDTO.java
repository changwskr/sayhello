package com.eplaton.skhu.business.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
	int id;
	String professorName;
	int DepartmentId;
	
	  List<CourseDTO> courses;

}
