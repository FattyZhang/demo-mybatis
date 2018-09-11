package com.zyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyg.model.Emp;

@Controller
public class RestFullController {
	
	@RequestMapping("boot/user/{id}/{name}/{age}")
	@ResponseBody
	public Object user(@PathVariable("id") Integer id,@PathVariable("name") String name ,@PathVariable("age") String age) {
		Emp e = new Emp();
		e.setId(id);
		e.setUser(name);
		e.setAge(age);
		return e;
	}
}
