package com.eplaton.skhu.business.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.eplaton.skhu.business.service.dto.StudentDTO;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM Student WHERE id = #{id}")
    StudentDTO findOne(int id);

    @Select("SELECT * FROM Student WHERE studentNumber = #{studentNumber}")
    StudentDTO findByStudentNumber(String studentNumber);



    @Insert("INSERT Student (studentNumber, name, departmentId, year)     " +
            "VALUES (#{studentNumber}, #{name}, #{departmentId}, #{year}) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(StudentDTO student);

    @Update("UPDATE Student SET                  " +
            "  studentNumber = #{studentNumber}, " +
            "  name = #{name},                   " +
            "  departmentId = #{departmentId},   " +
            "  year = #{year}                    " +
            "WHERE id = #{id}                    ")
    void update(StudentDTO student);

    @Delete("DELETE FROM Student WHERE id = #{id}")
    void delete(int id);

    @Select("SELECT s.*, d.departmentName          " +
            "FROM Student s LEFT JOIN department d " +
            " ON s.departmentId = d.id             ")
    List<StudentDTO> findAll();
}
