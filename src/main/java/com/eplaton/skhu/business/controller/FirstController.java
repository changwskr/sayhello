package com.eplaton.skhu.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eplaton.skhu.business.service.dto.ProductDTO;

@RestController
@RequestMapping("/first")
public class FirstController {

    @RequestMapping("test1")
    public String test1() {
        return "안녕하세요";
    }

    @RequestMapping("test2")
    public String[] test2() {
        return new String[] { "월", "화", "수", "목", "금", "토", "일" };
    }

    @RequestMapping("test3")
    public ProductDTO test3() {
        return new ProductDTO("맥주", 2000);
    }

    @RequestMapping("test4")
    public ProductDTO[] test4() {
        return new ProductDTO[] {
            new ProductDTO("맥주", 2000),
            new ProductDTO("우유", 1500)
        };
    }

}

