package com.user.vo;

public class UserVo {
	private int userId;//用户ID
	private String userName;//用户姓名
	private String userPassword;//用户密码
	private String userSex;//用户性别
	private int userDisplay;//用户状态
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userpassword) {
		this.userPassword = userpassword;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
}
