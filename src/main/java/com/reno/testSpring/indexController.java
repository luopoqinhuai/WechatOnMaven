package com.reno.testSpring;



import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class indexController {

	@RequestMapping("/")
	public String index(HttpServletRequest request,HttpServletResponse response){
		/*Cookie[] cks=request.getCookies();
		Cookie mycook=null;
		boolean First=true;
		
		for(Cookie ck:cks){
			if(ck.getName().equals("renoxxx")){
				mycook=ck;
				First=false;
				break;
			}
		}
		if(mycook==null){
			mycook=new Cookie("renoxxx", "haha");
		}
		if(First){
			return "index";
		}else{
			return "backconsles";
		}*/
		return "index";
		
		
	}
	
	
	@RequestMapping("/ceshi")
	public String ceshi(HttpServletRequest request) {
		Enumeration<String> em=request.getAttributeNames();
		while(true){
			try{
				String one=em.nextElement();
				System.out.println(one);
			}catch(Exception e){
				break;
			}
			
		
		}
		return "ceshi";
	}
	
	@RequestMapping("/checklogin")
	public String checkLogin(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("adsasdad");
		String username=request.getParameter("username");
		String passwd=request.getParameter("passwd");;
		Cookie[] cks=request.getCookies();
		Cookie mycook=null;
		boolean First=true;
		
		for(Cookie ck:cks){
			if(ck.getName().equals("renoxxx")){
				mycook=ck;
				First=false;
				break;
			}
		}
		
		if(mycook==null){
			mycook=new Cookie("renoxxx", "haha");
		}
		response.addCookie(mycook);
		if(First){
			System.out.println("你是第一次来");
		}else{
			System.out.println("你好老朋友");
		}

		System.out.println(username+"   "+passwd);
		return "index";
	}
	
}
