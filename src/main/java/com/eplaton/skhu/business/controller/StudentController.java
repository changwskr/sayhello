package com.eplaton.skhu.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eplaton.skhu.business.repository.mapper.DepartmentMapper;
import com.eplaton.skhu.business.repository.mapper.StudentMapper;
import com.eplaton.skhu.business.service.dto.DepartmentDTO;
import com.eplaton.skhu.business.service.dto.StudentDTO;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<StudentDTO> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        StudentDTO student = new StudentDTO();
        List<DepartmentDTO> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, StudentDTO student) {
        studentMapper.insert(student);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        StudentDTO student = studentMapper.findOne(id);
        List<DepartmentDTO> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, StudentDTO student) {
        studentMapper.update(student);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentMapper.delete(id);
        return "redirect:list";
    }
}
