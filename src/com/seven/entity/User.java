package com.seven.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 * 用户 实体类
 *
 * username：用户名
 * usersex：性别
 * userPassword：用户密码
 * useremail：电子邮件
 * userbirthday：出生日期
 * userflag：管理员标识
 *
 */
public class User {
	private String userName;
	private String userSex;
	private String userPassword;
	private String userEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	private Integer userFlag;

	public User() {
	}

	public User(String userName, String userSex, String userPassword, String userEmail, Date userBirthday, Integer userFlag) {
		this.userName = userName;
		this.userSex = userSex;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userBirthday = userBirthday;
		this.userFlag = userFlag;
	}

	public User(String userName, String userSex, String userPassword, String userEmail, Date userBirthday) {
		this.userName = userName;
		this.userSex = userSex;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userBirthday = userBirthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
}