package com.tutorials4u.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tutorials4u.dao.UserDAO;
import com.tutorials4u.dao.UserDAOImpl;
import com.tutorials4u.domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private List<User> userList = new ArrayList<User>();
	private UserDAO userDAO = new UserDAOImpl();
	
	public User getModel() {
		return user;
	}
	
	public String add()
	{
		userDAO.saveUser(user);
		return SUCCESS;
	}
	
	public String list()
	{
		userList = userDAO.listUser();
		return SUCCESS;
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
