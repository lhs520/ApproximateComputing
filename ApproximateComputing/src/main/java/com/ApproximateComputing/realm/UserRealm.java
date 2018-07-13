package com.ApproximateComputing.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ApproximateComputing.po.User;
import com.ApproximateComputing.service.UserService;
import com.ApproximateComputing.util.EncryptUtils;

public class UserRealm extends AuthorizingRealm{
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//这里编写登录认证的代码
		UsernamePasswordToken token2=(UsernamePasswordToken)token;
		String account=new String(token2.getUsername());
		String password=new String(token2.getPassword());//已经加密过的密码
		User user=userService.getUserByAccountAndPassword(account, password);
		if(user==null){
			throw new UnknownAccountException();
		}
		//密码加密
//		user.setPassword(EncryptUtils.encryptMD5(user.getPassword()));
		if(user.getPassword().equals(password)){
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
		}
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), // 工号
				user.getPassword(), getName() // realm name
		);
		return authenticationInfo;
	}

}
