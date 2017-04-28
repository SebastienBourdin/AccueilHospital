package com.hopital.action;

import java.util.ArrayList;
import java.util.List;


import com.hopital.domain.User;
import com.hopital.model.Usermdl;
import com.hopital.model.Usermdlimp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{


	private static final long serialVersionUID = 1L;
	private User User  = new User();
	private List<User> userList = new ArrayList<User>();
	private Usermdl dao = new Usermdlimp();
	
	@Override
	public User getModel() {
		return User;
	}

	public String addUser()
	{	
		System.out.println(User.toString());
		dao.addUser(User);
		return "success";
	}

	public String listUsers()
	{
		userList = dao.getUsers();
		return SUCCESS;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> Users) {
		this.userList = Users;
	}
	
	public String deleteUser(){

		//Je n'ai pas compris tu fonction customList, donc je n'ai pas fait cette fonction qui l'utilise.
			return NONE;
	}
	

}