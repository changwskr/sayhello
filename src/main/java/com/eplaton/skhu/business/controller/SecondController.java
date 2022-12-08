package com.eplaton.skhu.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eplaton.skhu.business.service.dto.ProductDTO;

@Controller
@RequestMapping("/second")
public class SecondController {

    @RequestMapping("test1")
    public String test1(Model model) {
        model.addAttribute("message", "안녕하세요");
        return "second/test1";
    }

    @RequestMapping("test2")
    public String test2(Model model) {
        ProductDTO product = new ProductDTO("맥주", 2000);
        model.addAttribute("product", product);
        return "second/test2";
    }

}
