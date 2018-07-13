package com.ApproximateComputing.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ApproximateComputing.po.User;
import com.ApproximateComputing.vo.CommonDTO;

public interface UserService {
	public String login(String acount,String password);
	public User getUserByAccountAndPassword(String account,String password);
}
