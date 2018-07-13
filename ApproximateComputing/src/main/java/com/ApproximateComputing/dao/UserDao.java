package com.ApproximateComputing.dao;

import org.apache.ibatis.annotations.Param;

import com.ApproximateComputing.po.User;

public interface UserDao {
	public String getIdByAccountAndPassword(@Param("account")String account,@Param("password")String password);
	public String getIdByAccount(@Param("account")String account);
	public void addUser(User user);
	public User getUserById(@Param("id")String id);
	public User getUserByAccountAndPassword(@Param("account")String account,@Param("password")String password);
}
