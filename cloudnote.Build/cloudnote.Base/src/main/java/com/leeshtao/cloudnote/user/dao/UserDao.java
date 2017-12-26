package com.leeshtao.cloudnote.user.dao;

import com.leeshtao.cloudnote.user.entity.User;

public interface UserDao {
	User findUserByName(String name);
	void addUser(User user);
	User findByUserId(Long userId);
	void updateLogin(Long userId);
	void deleteLogicUser(Long userId );
}
