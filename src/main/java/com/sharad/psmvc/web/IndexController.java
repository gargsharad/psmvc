package com.sharad.psmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/WEB-INF/views/index.jsp");
		mav.addObject("theModelKey", "Spring says HI!");
		return mav;
	}
	
	@RequestMapping(value = "/index2.htm")
	public ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/WEB-INF/views/index2.jsp");
		mav.addObject("theModelKey", "Spring says HI!");
		return mav;
	}

}
