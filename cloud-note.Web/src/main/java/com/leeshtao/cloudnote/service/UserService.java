package com.leeshtao.cloudnote.service;

import com.leeshtao.cloudnote.entity.User;

public interface UserService {
	User login(String name,String password)
		throws NameException,PasswordException;
	User regist(String name,String password,String nick)
			throws NameException,PasswordException;
	void cancelUser(String name) throws NameException;
}
