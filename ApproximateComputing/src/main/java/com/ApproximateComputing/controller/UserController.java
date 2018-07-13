package com.ApproximateComputing.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ApproximateComputing.po.User;
import com.ApproximateComputing.service.UserService;
import com.ApproximateComputing.util.EncryptUtils;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Controller
//@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
//	//跳转到登录页面
//	@RequestMapping(value="/login",method=RequestMethod.GET)
//	public String login(){
//		return "index";
//	}
	
	//登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public CommonDTO login(@RequestBody User user){
		
		if(user.getAccount()==null||user.getPassword()==null){
			return new CommonDTO(Result.PARAM_ERROR);
		}
		//进行密码加密MD5
		UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(),EncryptUtils.encryptMD5(user.getPassword()));
		try{
			//登录时验证账号密码，错误时抛出相应异常
			SecurityUtils.getSubject().login(token);
			return new CommonDTO(Result.SUCCESS);
		}catch(UnknownAccountException e){
			//账号不存在
			return new CommonDTO(Result.UNKNOWN_ACCOUNT_ERROR);
		}catch(IncorrectCredentialsException e){
			//密码错误
			return new CommonDTO(Result.INCORRECT_CREDENTIALS_ERROR);
		}catch(Exception e){
			//系统出错，请联系管理员
			return new CommonDTO(Result.OTHER_LOGIN_ERRROR);
		}
	}
	
	//退出系统
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "index";
	}
}
