package com.leeshtao.cloudnote.user.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.common.ExceptionController;
import com.leeshtao.cloudnote.common.exception.NameException;
import com.leeshtao.cloudnote.common.exception.PasswordException;
import com.leeshtao.cloudnote.user.entity.User;
import com.leeshtao.cloudnote.user.handler.UserService;
import com.leeshtao.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/user")
public class UserController extends ExceptionController{

	@Resource
	private UserService userService;
	@ResponseBody
	@RequestMapping("/login.do")//此处对应的是log_in.html中发送Ajax请求中的url中定义的
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
	
	@ExceptionHandler(NameException.class)//集中处理NameException.class类型的异常
	@ResponseBody
	public JsonResult nameExp(NameException e) {
		e.printStackTrace();
		return new JsonResult(2, e);
	}
	
	@ExceptionHandler(PasswordException.class)//集中处理PasswordException.class类型的异常
	@ResponseBody
	public JsonResult pwdExp(PasswordException e) {
		e.printStackTrace();
		return new JsonResult(3,e);
	}
}
