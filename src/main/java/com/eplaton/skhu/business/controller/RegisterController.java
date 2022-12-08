package com.eplaton.skhu.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eplaton.skhu.business.repository.mapper.RegisterMapper;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired RegisterMapper registerMapper;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("registers", registerMapper.findAll());
        return "register/list";
    }

}


