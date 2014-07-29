package com.sharad.psmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private static final Logger _log = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping(value = "/index.jsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		_log.debug("Enter IndexController handleRequest");
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("theModelKey", "Spring says HI!");
		return mav;
	}
	
	@RequestMapping(value = "/index2.jsp")
	public ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/WEB-INF/views/index2.jsp");
		mav.addObject("theModelKey", "Spring says HI!");
		return mav;
	}

}
