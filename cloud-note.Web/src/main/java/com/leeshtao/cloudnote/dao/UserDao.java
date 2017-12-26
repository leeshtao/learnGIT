package com.leeshtao.cloudnote.dao;


import com.leeshtao.cloudnote.entity.User;

public interface UserDao {
	User findUserByName(String name);
	void addUser(User user);
	User findByUserId(String userId);
	void updateLogin(Long userId);
	void deleteLogicUser(Long userId );
}
