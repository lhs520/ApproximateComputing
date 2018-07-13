package com.ApproximateComputing.vo;


public class CommonDTO {
	
	
	private int code;
	private String msg;
	private Object result;
	
	public CommonDTO(){
		
	}
	
	public CommonDTO(Result result){
		this.code=result.getCode();
		this.msg=result.getMsg();
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getResult() {
		return result;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
}
