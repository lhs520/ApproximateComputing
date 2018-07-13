package com.ApproximateComputing.vo;


public enum Result {
	
	SUCCESS(0,"成功"),
	UNKNOWN_ACCOUNT_ERROR(1,"账号不存在"),
	INCORRECT_CREDENTIALS_ERROR(2,"密码错误"),
	OTHER_LOGIN_ERRROR(4,"请联系管理员"),//登录时发生的其他错误
	PARAM_ERROR(5,"参数错误"),
	
	FAILURE(110,"失败，请重试!"),
	
	SYSTEM_EXCEPTION(500,"系统异常，请联系管理员");
	
	
	private int code;
	private String msg;
	
	private Result(){
		
	}
	
	private Result(int code,String msg){
		this.code=code;
		this.msg=msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
	
	
}
