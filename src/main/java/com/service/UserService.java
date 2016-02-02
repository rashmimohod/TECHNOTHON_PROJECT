package com.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;
import com.dao.UserDao;

public class UserService {
	private static ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
	UserDao udao=(UserDao)context.getBean("udao");
	public List<User> getUserlist(){
		
		
		return udao.getAllUsers();
		
	}
public void deleteuser(User u){
		
		
	udao.deleteUser(u);
	}
}
