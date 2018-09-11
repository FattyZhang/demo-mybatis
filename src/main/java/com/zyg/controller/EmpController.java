package com.zyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyg.model.Emp;
import com.zyg.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("boot/insert")
	public Object insert() {
		Emp e = new Emp();
		e.setUser("»¨ßÂ");
		e.setAge("99");
		return empService.insert(e);
	}
	
	
	@GetMapping("boot/updata")
	public Object updata() {
		System.out.println("updata........");
		return empService.updateByPrimaryKeySelective(new Emp());
	}
	
	@RequestMapping("boot/select/{id}")
	public Object select(@PathVariable("id") Integer id) {
		Emp e = empService.selectByPrimaryKey(id);
		return e;
	}
	
}












