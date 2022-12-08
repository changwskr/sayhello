package com.eplaton.skhu.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first120601")
public class FirstController_120601 {

	//	http://localhost:8088/first120601/test1120601http://localhost:8088/first120601/test1120601?id=3&name=%ED%99%8D%EA%B8%B8%EB%8F%99
    @RequestMapping("test1120601")
    public String test1(Model model, @RequestParam("id") int id,
                                     @RequestParam("name") String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1120601";
    }

    @RequestMapping("test2120601")
    public String test2(Model model,
            @RequestParam(value="id", required=false, defaultValue="0") int id,
            @RequestParam(value="name", required=false, defaultValue="nobody") String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1120601";
    }

    @RequestMapping("test3120601")
    public String test3(Model model, int id, String name) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "first/test1120601";
    }
}

