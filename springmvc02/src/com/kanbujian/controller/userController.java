package com.kanbujian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kanbujian.model.user;
import com.kanbujian.service.userService;

@Controller
@RequestMapping("/user")
public class userController {
    private static userService us;

    public userService getUs() {
		return us;
	}
    @Resource(name="userService")
	public void setUs(userService us) {
		this.us = us;
	}
	/*
     * 展示用户信息
     */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	 public String list(Model model){
		 List<user> users=us.list();
		/* Map<String,user> userMap=new HashMap<String,user>();
		// model.addAttribute("users",users);
		 Iterator<user> it=users.iterator();
		 while(it.hasNext()){
			 user u=it.next();
			 System.out.println(u.getUsername()+"  "+u.getPassword());
			 userMap.put(u.getUsername(), u);
		 }*/
	     //map形式 
		// model.addAttribute("userMap", userMap);
		 //直接list形式
		 model.addAttribute("userMap", users);
		 
		/*--just for testing 测试addAllAttributes（list） jsp遍历-->*/
		/* List<String> strList=new ArrayList<String>();
		 strList.add("hsuhsush1");
		 strList.add("shdushdiu2");
		 strList.add("ahsiasui3");
		 model.addAllAttributes(strList);*/
		 
		 model.addAttribute("PageTitle", "心系");
	
		 
    	 return "/user/list";
	 }
	/*
	 * 添加用户信息
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("user1",new user());
		return "/user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated user u,BindingResult br){
		if(br.hasErrors())
			return "redirect:/user/add";
		us.add(u);
		return "redirect:/user/users";
		
	}
	/*
	 * 展示单个用户信息
	 */
	@RequestMapping(value="/{username}/show",method=RequestMethod.GET)
	public String show(@PathVariable String username,Model model){
		model.addAttribute(us.show(username));
		return "/user/show";		
		
	}
	/*@RequestMapping(value="/{username}/show",method=RequestMethod.GET,params="json")
	public String show(@PathVariable String username){
		
		return "/user/show";		
		
	}*/
	
	/*
	 * 修改用户信息
	 */
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username,Model model){
		model.addAttribute("user",new user());
		System.out.println("dao zhe mei ?");
		return "/user/update";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@Validated user u,BindingResult br,Model model){
		if(br.hasErrors())
				return "/user/update";
		us.update(u);
		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="{username}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String username,Model model){
        us.delete(username); 
        return "redirect:/user/users";
	}
	
}
