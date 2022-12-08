package com.eplaton.skhu.business.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable  {
	
    private static final long serialVersionUID = 1L;
    int id;
    String studentNumber;
    String name;
    int departmentId;
    int year;
    String departmentName;

   
}

