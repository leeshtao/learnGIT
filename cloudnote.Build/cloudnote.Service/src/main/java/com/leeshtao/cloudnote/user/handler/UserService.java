package com.leeshtao.cloudnote.user.handler;

import com.leeshtao.cloudnote.common.exception.NameException;
import com.leeshtao.cloudnote.common.exception.PasswordException;
import com.leeshtao.cloudnote.user.entity.User;

public interface UserService {
	User login(String name,String password)
		throws NameException,PasswordException;
	User regist(String name,String password,String nick)
			throws NameException,PasswordException;
	void cancelUser(String name) throws NameException;
}
