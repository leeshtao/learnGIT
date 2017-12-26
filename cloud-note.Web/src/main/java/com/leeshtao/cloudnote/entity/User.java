package com.leeshtao.cloudnote.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import com.leeshtao.cloudnote.common.SqlBase;
public class User extends SqlBase implements Serializable{

	private static final long serialVersionUID = -8556786528428859738L;
	
	
	private String cnUserName;
	
	private String cnUserPassword;
	
	private String cnUserToken;

	private String cnUserNick;

	
	
	public User() {
		super();
	}

	public String getCnUserName() {
		return cnUserName;
	}

	public void setCnUserName(String cnUserName) {
		this.cnUserName = cnUserName;
	}

	public String getCnUserPassword() {
		return cnUserPassword;
	}

	public void setCnUserPassword(String cnUserPassword) {
		this.cnUserPassword = cnUserPassword;
	}

	public String getCnUserToken() {
		return cnUserToken;
	}

	public void setCnUserToken(String cnUserToken) {
		this.cnUserToken = cnUserToken;
	}

	public String getCnUserNick() {
		return cnUserNick;
	}

	public void setCnUserNick(String cnUserNick) {
		this.cnUserNick = cnUserNick;
	}
	
	
}
