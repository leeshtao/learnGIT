package com.leeshtao.cloudnote.share.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.share.entity.Share;
import com.leeshtao.cloudnote.share.handler.ShareService;
import com.leeshtao.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/share")
public class ShareController {
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult shareNote(Long noteId){
		shareService.saveShareNote(noteId);
		JsonResult result = new JsonResult();
		result.setState(0);
		result.setMessage("分享笔记成功");
		return result;
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonResult showShareNote(String keyword,int page){
		List<Share> list = shareService.searchShareNote(keyword,page);
		return new JsonResult(list);
	}
}
