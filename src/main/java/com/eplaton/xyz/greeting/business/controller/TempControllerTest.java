package com.eplaton.xyz.greeting.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller라고 어노테이션을 쓴 이유는 데이타를 리턴하는 것이 아니라 파일을 리턴할려고 해서 그렇다.
public class TempControllerTest {

	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}

	@GetMapping("/temp/img")
	public String tempImg() {
		return "/flowing.jpg";
	}

	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		System.out.println("/temp/jsp---------------");

		return "test";
	}
}

class TempControllerTestOrg {

	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}

	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.png";
	}

	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp

		return "test";
	}
}