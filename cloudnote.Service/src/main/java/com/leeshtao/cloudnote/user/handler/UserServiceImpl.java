package com.leeshtao.cloudnote.user.handler;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.leeshtao.cloudnote.common.exception.NameException;
import com.leeshtao.cloudnote.common.exception.PasswordException;
import com.leeshtao.cloudnote.user.dao.UserDao;
import com.leeshtao.cloudnote.user.entity.User;
import com.leeshtao.cloudnote.util.NoteUtil;

import util.Object2JSON;

@Service("userService")
//@JsonRemote
public class UserServiceImpl implements UserService{
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Inject
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
			logger.error("密码错误,用户ID:"+user.getId());
			throw new PasswordException("密码错误");
		}
		
	}

	public User regist(String cnUserName, String cnUserPassword, String cnUserNick) throws NameException, PasswordException {
		//检测用户名是否存在
		User user = userDao.findUserByName(cnUserName);
		if(user!=null){
			logger.error("用户名被占用");
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
		user = new User();
		user.setCnUserName(cnUserName);
		user.setCnUserPassword(cnUserPassword);
		user.setCnUserNick(cnUserNick);
		user.setCnUserToken(cnUserToken);
		
		userDao.addUser(user);
		
		user = userDao.findUserByName(cnUserName);
		
		logger.info("新注册用户:"+Object2JSON.object2JSON(user));
		return user;
	}

	public void cancelUser(String name) {
		User user = userDao.findUserByName(name);
		if (user != null) {
			userDao.deleteLogicUser(user.getId());
		}else {
			logger.error("用户不存在");
			throw new NameException("用户不存在");
		}
		
		
	}

}
