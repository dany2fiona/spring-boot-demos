package com.dany.entity;

import com.dany.enums.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "user",description = "用户")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "用户标识",hidden = true)
	private Long id;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	@ApiModelProperty(value = "密码")
	private String passWord;
	@ApiModelProperty(value = "性别")
	private UserSexEnum userSex;
	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	public UserEntity() {
		super();
	}

	public UserEntity(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}

	public UserEntity(String userName, String passWord, UserSexEnum userSex, String nickName) {
		this.userName = userName;
		this.passWord = passWord;
		this.userSex = userSex;
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name();
	}

}