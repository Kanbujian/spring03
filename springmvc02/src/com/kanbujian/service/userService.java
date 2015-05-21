package com.kanbujian.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.kanbujian.Hibernatedao.userDaoImpl;
import com.kanbujian.model.user;


public class userService {
	userDaoImpl hibernateDAO;
    
	
	
	public userDaoImpl getHibernateDAO() {
		return hibernateDAO;
	}



	public void setHibernateDAO(userDaoImpl hibernateDAO) {
		this.hibernateDAO = hibernateDAO;
	}



	public void add(user u){
		hibernateDAO.add(u);
	}
	public void delete(String username){
		hibernateDAO.delete(username);
		
	}
	public void update(user u){
		hibernateDAO.update(u);
	}
	public user show(String username){
		return hibernateDAO.show(username);
	}
	public List<user> list(){
		return hibernateDAO.list();
	}

}
