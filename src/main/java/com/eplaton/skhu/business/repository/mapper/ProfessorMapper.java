package com.eplaton.skhu.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.eplaton.skhu.business.service.dto.ProfessorDTO;

@Mapper
public interface ProfessorMapper {

    // @Select("SELECT * FROM professor")
    List<ProfessorDTO> findAll();
}
