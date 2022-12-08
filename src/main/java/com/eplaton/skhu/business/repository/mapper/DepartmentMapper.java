package com.eplaton.skhu.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.eplaton.skhu.business.service.dto.DepartmentDTO;

@Mapper
@CacheNamespace(flushInterval=10000)
public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<DepartmentDTO> findAll();

    @Select("SELECT * FROM department WHERE id = #{id}")
    DepartmentDTO findOne(int id);

    @Insert("INSERT department (departmentName) VALUES (#{departmentName})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(DepartmentDTO department);
	
    @Update("UPDATE department SET departmentName = #{departmentName} WHERE id = #{id}")
    void update(DepartmentDTO department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    void delete(int id);
}

