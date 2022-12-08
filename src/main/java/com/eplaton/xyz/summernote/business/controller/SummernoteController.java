package com.eplaton.xyz.summernote.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Controller라고 어노테이션을 쓴 이유는 데이타를 리턴하는 것이 아니라 파일을 리턴할려고 해서 그렇다.
public class SummernoteController {

	// http://localhost:8002/summernote/welcome
	@GetMapping("/summernote/welcome")
	public String ajaxJsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		System.out.println("1) controller-/summernote called");

		return "/summernote/summernote_welcomehome";
	}

}
