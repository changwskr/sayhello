package com.eplaton.xyz.ajaxtunnelling.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller라고 어노테이션을 쓴 이유는 데이타를 리턴하는 것이 아니라 파일을 리턴할려고 해서 그렇다.
public class AjaxController {

	// http://localhost:8002/eplaton/ajaxtest
	@GetMapping("/ajaxtunnelling")
	public String ajaxJsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		System.out.println("1) controller-/ajaxtunnelling called");
		System.out.println("2) controller-ajaxtunnelling called");

		return "/ajaxtunnelling/ajaxtunnelling";
	}

}
