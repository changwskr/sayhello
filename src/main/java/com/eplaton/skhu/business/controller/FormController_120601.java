package com.eplaton.skhu.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eplaton.skhu.business.repository.mapper.DepartmentMapper;
import com.eplaton.skhu.business.service.dto.StudentDTO;

@Controller
@RequestMapping("/form_120601")
public class FormController_120601 {

    @Autowired DepartmentMapper departmentMapper;

    @GetMapping("edit1")
    public String edit1(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "form/edit1";
    }

    @PostMapping("edit1")
    public String edit1(Model model, StudentDTO student) {
        // TODO: DB 저장 기능을 구현해야 함.
        model.addAttribute("message", "저장했습니다.");
        return "form/edit1";
    }

    @GetMapping("edit2")
    public String edit2(Model model) {
        model.addAttribute("student", new StudentDTO());
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit2";
    }

    @PostMapping("edit2")
    public String edit2(Model model, StudentDTO student) {
        // TODO: DB 저장 기능을 구현해야 함.
        model.addAttribute("message", "저장했습니다.");
        model.addAttribute("departments", departmentMapper.findAll());
        return "form/edit2";
    }
}

