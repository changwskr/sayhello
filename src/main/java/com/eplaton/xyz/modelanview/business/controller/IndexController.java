package com.eplaton.xyz.modelanview.business.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// HttpServlet을 상속받아서 하지 않곗다. 
//public class indexController extends HttpServlet{
//
//}

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("IndexController called");
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList();
		list.add("kimm");
		list.add("aaa");
		
		User k = new User();
		k.setName("qqqq");
		
		
		mv.addObject("data", "Hello Spring MVC");
		mv.addObject("k", k);
		mv.addObject("list", list);
		
		mv.setViewName("index.jsp");		
		return mv;
	}
	
}

class User {
	public String name="aaa";
	public void setName(String aa) {
		name = aa;
	}
}
