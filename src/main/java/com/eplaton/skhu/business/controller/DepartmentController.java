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
import com.eplaton.skhu.business.service.dto.DepartmentDTO;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<DepartmentDTO> departments = departmentMapper.findAll();
        model.addAttribute("departments", departments);
        return "department/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("department", new DepartmentDTO());
        return "department/edit";
    }

    @PostMapping("create")
    public String create(Model model, DepartmentDTO department) {
        departmentMapper.insert(department);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        DepartmentDTO department = departmentMapper.findOne(id);
        model.addAttribute("department", department);
        return "department/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, DepartmentDTO department) {
        departmentMapper.update(department);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        departmentMapper.delete(id);
        return "redirect:list";
    }
}
