package com.reno.testSpring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reno.mybatis.mybaitsTest;
import com.reno.testSpring.beans.User;

@Controller
@RequestMapping("/mvc")
public class mvcController {

	public mvcController() {
		System.out.println("===============");
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("name","reno");
		mp.put("age","12");
		
		return new ModelAndView("index",mp);
	}
	

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/hello2")
	@ResponseBody
	public String test() {
		return "Welcome";
	}

	/*
	 * @RequestMapping("/hello3")
	 * 
	 * @ResponseBody public String test2(){ mybaitsTest.addUser(); return
	 * "hahha"; }
	 */

}
