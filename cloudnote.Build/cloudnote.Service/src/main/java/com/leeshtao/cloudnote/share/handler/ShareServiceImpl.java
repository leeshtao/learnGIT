package com.leeshtao.cloudnote.share.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.leeshtao.cloudnote.note.dao.NoteDao;
import com.leeshtao.cloudnote.note.entity.Note;
import com.leeshtao.cloudnote.share.dao.ShareDao;
import com.leeshtao.cloudnote.share.entity.Share;

import util.Object2JSON;


@Service("shareService")
public class ShareServiceImpl implements ShareService{
	private static final Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class);
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	public void saveShareNote(Long noteId){
		//获取分享笔记的数据
		Share share = new Share();
		Note note = noteDao.findByNoteId(noteId);
		if (note==null) {
			logger.error("分享的笔记不存在");
			return;
		}
		Map map = new HashMap();
		map.put("noteId", noteId);
		map.put("title", note.getCnNoteTitle());
		Share share1 = shareDao.findByNoteIdAndTitle(map);
		if (share1 != null) {
			logger.error("不能重复分享同一笔记");
			return;
		}
		share.setCnNoteId(noteId);
		share.setCnShareTitle(note.getCnNoteTitle());
		share.setCnShareBody(note.getCnNoteBody());
		//保存分享记录
		shareDao.save(share);
		share = shareDao.findById().get(0);
		logger.info(Object2JSON.object2JSON(share));
	}
	
	public List<Share> searchShareNote(String keyword,int page) {
		String title="%";
		if(keyword!=null && !"".equals(keyword)){
			title="%"+keyword.trim()+"%";
		}
		//计算抓取记录的起点
		int begin=(page-1)*3;
		Map params = new HashMap();
		params.put("title", title);//对应#{title}
		params.put("begin", begin);//对应#{begin}
		List<Share> list = shareDao.findLikeTitle(params);
		if (list.isEmpty() || list==null) {
			logger.error("找不到相关分享内容");
			return null;
		}
		return list;
	}
}







