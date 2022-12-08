package com.eplaton.skhu.business.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eplaton.skhu.business.repository.mapper.CourseMapper;
import com.eplaton.skhu.business.repository.mapper.ProfessorMapper;
import com.eplaton.skhu.business.service.dto.ProfessorDTO;

@Controller
public class ProfessorController {

    @Autowired ProfessorMapper professorMapper;
    @Autowired CourseMapper courseMapper;

    @RequestMapping("professor/list")
    public String list(Model model) {
        List<ProfessorDTO> professors = professorMapper.findAll();
        for (ProfessorDTO professor : professors)
            professor.setCourses(courseMapper.findByProfessorId(professor.getId()));
        model.addAttribute("professors", professors);
        return "professor/list";
    }

}
