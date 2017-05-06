package com.hopital.model;

import java.util.List;

import com.hopital.domain.User;

public interface Usermdl {
   public List<User> getUsers();
   public void addUser(User User);
   public List<User> listUser(User user);
   public void delete(String user_id);
   public void updateUser(User user);
}