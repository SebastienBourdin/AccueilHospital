package com.tutorials4u.dao;

import java.util.List;

import com.tutorials4u.domain.User;

public interface UserDAO {

	public void saveUser(User user);
	public List<User> listUser();
}
