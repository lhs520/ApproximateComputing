package com.ApproximateComputing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApproximateComputing.dao.UserDao;
import com.ApproximateComputing.po.User;
import com.ApproximateComputing.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public String login(String acount, String password) {
		String id = userDao.getIdByAccountAndPassword(acount, password);
		if (id == "" || id == null) {
			String acount_id = userDao.getIdByAccount(acount);
			if (acount_id == "" || acount_id==null) {
				return new String("UNKNOWN_ACCOUNT");
			} else {
				return new String("INCORRECT_CREDENTIALS");
			}
		}
		return id;
	}
	@Override
	public User getUserByAccountAndPassword(String account, String password) {
		return userDao.getUserByAccountAndPassword(account, password);
	}
}
