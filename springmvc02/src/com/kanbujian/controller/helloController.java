package com.kanbujian.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kanbujian.exception.UserException;
import com.kanbujian.model.user;
import com.kanbujian.service.userService;

@Controller
public class helloController {
    
	
	@RequestMapping("index")
	public String hello(){
		return "index";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		
		userService us=new userController().getUs();
				
		 List<user> users=us.list();
		/* Iterator<user> it=users.iterator();
		 while(it.hasNext()){
			 user u=it.next();
			 System.out.println(u.getUsername()+"  "+u.getPassword());
			
		 }*/
		user u=us.show(username);		
		//System.out.println(u.getUsername()+"  "+u.getPassword()+"  "+u.getEmail());
		/* 重写equals（）方法
		 * list.contains(o)，系统会对list中的每个元素e调用o.equals(e)，方法，
		 * 加入list中有n个元素，那么会调用n次o.equals(e)，只要有一次o.equals(e)
		 * 返回了true，那么list.contains(o)返回true，否则返回false。
		 * */
		if(!users.contains(u)){
			//用户名不存在，只验证用户名是否相等
			//System.out.println("用户名不存在");
			throw new UserException("用户名不存在");
			/*return "login";*/
		}
		if(!u.getPassword().equals(password)){
			System.out.println("密码不正确");
			throw new UserException("密码不正确");
			/*return "login";*/
		}
		session.setAttribute("LoginUser", u);
		return "redirect:user/users";
	}
	/*
	 * 局部异常处理
	 * 只能处理这个控制器中的异常
	 */
	/*@ExceptionHandler(value=UserException.class)
	public String handlerException(UserException u,HttpServletRequest request){
		request.setAttribute("errorMessage", u);
		return "error";		
	}*/
}
