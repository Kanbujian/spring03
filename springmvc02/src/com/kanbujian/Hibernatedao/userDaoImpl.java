package com.kanbujian.Hibernatedao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kanbujian.dao.userDAO;
import com.kanbujian.model.user;

public class userDaoImpl implements userDAO{
    
	SessionFactory sessionFactory;
	Session session;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(user u) {
		session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		user u=show(username);
		session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
		
	}

	@Override
	public void update(user u) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(u);;
		session.getTransaction().commit();
		
	}

	@Override
	public user show(String username) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		/*报could not initialize proxy - no Session异常, load生成的是代理对象*/
		//user u=(user)session.load(user.class,username);
		user u=(user)session.get(user.class,username);
		session.getTransaction().commit();
		
		return u;
	}
	@Override
	public List<user> list() {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<user> result=(List<user>) session.createQuery("from user").list();
	    System.out.println("数据库遍历成功！");
		session.getTransaction().commit();
		
	
		return result;
	}

}
