package com.leeshtao.cloudnote.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.leeshtao.cloudnote.dao.UserDao;
import com.leeshtao.cloudnote.entity.User;
import com.leeshtao.cloudnote.util.NoteUtil;

@Service("userService")
//@JsonRemote
public class UserServiceImpl implements UserService{
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserDao userDao;
	public User login(String name, String password) throws NameException, PasswordException {
		if(name==null || name.trim().isEmpty()){
			logger.debug("用户名不能为空");
			throw new NameException("用户名不能为空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		//密码检验
		User user= userDao.findUserByName(name);
		if(user==null){
			logger.error("用户名错误");
			throw new NameException("用户名错误");
		}
		String md5Password=NoteUtil.md5(password);
		if(user.getCnUserPassword().equals(md5Password)){
			userDao.updateLogin(user.getId());
			logger.info("登录时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
					+",用户:"+user.getCnUserName()
					+",用户ID:"+user.getId());
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
		
	}

	public User regist(String cnUserName, String cnUserPassword, String cnUserNick) throws NameException, PasswordException {
		//检测用户名是否存在
		User user
			=userDao.findUserByName(cnUserName);
		if(user!=null){
			throw new NameException("用户名被占用");
		}
//		//生成ID
//		String id=NoteUtil.createId();
		
		if(cnUserNick==null || cnUserNick.trim().isEmpty()){
			cnUserNick=cnUserName;
		}
		String cnUserToken=UUID.randomUUID().toString().replaceAll("-", "")+UUID.randomUUID().toString().replaceAll("-", "");
		cnUserToken = cnUserToken.substring(0,40);
		cnUserPassword=NoteUtil.md5(cnUserPassword);
		User user2 = new User();
		user2.setCnUserName(cnUserName);
		user2.setCnUserPassword(cnUserPassword);
		user2.setCnUserNick(cnUserNick);
		user2.setCnUserToken(cnUserToken);
		
		userDao.addUser(user2);
		return user2;
	}

	public void cancelUser(String name) {
		User user = userDao.findUserByName(name);
		if (user != null) {
			userDao.deleteLogicUser(user.getId());
		}else {
			throw new NameException("用户不存在");
		}
		
		
	}

}
