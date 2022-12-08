package com.eplaton.skhu.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.eplaton.skhu.business.service.dto.CourseDTO;

@Mapper
public interface CourseMapper {

    @Select("SELECT * FROM course WHERE professorId = #{professorId}")
    List<CourseDTO> findByProfessorId(int professorId);

}

