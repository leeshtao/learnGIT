package com.leeshtao.cloudnote.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.entity.User;
import com.leeshtao.cloudnote.service.NameException;
import com.leeshtao.cloudnote.service.PasswordException;
import com.leeshtao.cloudnote.service.UserService;
import com.leeshtao.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/user")
public class UserController extends ExceptionController{

	@Resource
	private UserService userService;
	@ResponseBody
	@RequestMapping("/login.do")//�˴���Ӧ����log_in.html�з���Ajax�����е�url�ж����
	public Object login(String name,String password){
			User user = userService.login(name, password);
			return new JsonResult(user);
	}
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String name,String password,String nick){
		User user = userService.regist(name, password, nick);
		return new JsonResult(user);
	}
	
	@ExceptionHandler(NameException.class)
	//���д���NameException.class���͵��쳣
	@ResponseBody
	public JsonResult nameExp(NameException e) {
		e.printStackTrace();
		return new JsonResult(2, e);
	}
	
	@ExceptionHandler(PasswordException.class)
	//���д���PasswordException.class���͵��쳣
	@ResponseBody
	public JsonResult pwdExp(PasswordException e) {
		e.printStackTrace();
		return new JsonResult(3,e);
	}
}
