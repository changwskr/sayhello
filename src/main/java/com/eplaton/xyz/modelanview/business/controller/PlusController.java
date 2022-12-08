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

public class PlusController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("plusController called");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("data", "Hello Spring MVC");
		
		mv.setViewName("plus.jsp");		
		return mv;
	}
	
}

