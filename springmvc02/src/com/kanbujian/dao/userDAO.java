package com.kanbujian.dao;

import java.util.List;
import java.util.Map;

import com.kanbujian.model.user;

public interface userDAO {
	public void add(user u);
	public void delete(String username);
	public void update(user u);
	public user show(String username);
	public List<user> list();

}
