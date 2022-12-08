package com.eplaton.skhu.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.eplaton.skhu.business.service.dto.RegisterDTO;

@Mapper
public interface RegisterMapper {

    @Select("SELECT r.*, s.studentNumber, s.name studentName, c.courseName, c.unit " +
            " FROM register r JOIN student s ON r.studentId = s.id                 " +
            "                 JOIN course c ON r.courseId = c.id                   " +
            " ORDER BY s.studentNumber                                             ")
    List<RegisterDTO> findAll();

}
