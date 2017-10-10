package cn.yhj.entity;

import java.io.Serializable;

public class UserLogin implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String userCode;
	
	private String userName;
	
	private String passWord;

	public UserLogin(Integer id, String userCode, String userName,
			String passWord) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.passWord = passWord;
	}
	public UserLogin(String userName,
			String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public UserLogin() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", passWord=" + passWord
				+ "]";
	}
	

	
	
	
	
}
