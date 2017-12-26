package com.leeshtao.cloudnote.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.util.JsonResult;


/**
 * 集中处理异常
 *
 */
public abstract class ExceptionController {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exp(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
