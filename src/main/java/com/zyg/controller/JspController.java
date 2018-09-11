package com.zyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping("boot/index")
	public String hello(Model model) {
		System.out.println("hello......");
		model.addAttribute("test", "springboot 集成 JSP"); 
		return "index";
	}
}





