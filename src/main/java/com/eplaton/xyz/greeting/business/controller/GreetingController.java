package com.eplaton.xyz.greeting.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		System.out.println("-------------");
		model.addAttribute("name", name);
		return "index";
		// return "WEB-INF/views/index.jsp";
	}

}