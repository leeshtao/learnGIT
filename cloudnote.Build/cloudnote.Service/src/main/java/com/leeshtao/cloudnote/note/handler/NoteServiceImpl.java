package com.leeshtao.cloudnote.note.handler;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.leeshtao.cloudnote.book.dao.BookDao;
import com.leeshtao.cloudnote.book.entity.Book;
import com.leeshtao.cloudnote.common.exception.NoteBookNotFoundException;
import com.leeshtao.cloudnote.common.exception.UserNotFoundException;
import com.leeshtao.cloudnote.note.dao.NoteDao;
import com.leeshtao.cloudnote.note.entity.Note;
import com.leeshtao.cloudnote.user.dao.UserDao;
import com.leeshtao.cloudnote.user.entity.User;
import com.leeshtao.cloudnote.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
	private static Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);
	@Resource
	private BookDao bookDao;
	@Resource
	private NoteDao noteDao;
	@Resource
	private UserDao userDao;
	
	public List<Note> listNotes(Long bookId) throws NoteBookNotFoundException {
		if(bookId==null){
			throw new NoteBookNotFoundException(
					"Book ID不能为空");
		}
		//判断bookId是否有效
		Book book = bookDao.findByBookId(bookId);
		if(book==null){
			throw new NoteBookNotFoundException(
					"笔记本不存在");
		}
		List<Note> list = noteDao.findByBookId(bookId);
		
		return list;
	}

	public Note addNote(Long userId, Long bookId, String noteTitle) {
		User user = userDao.findByUserId(userId);
		if (user == null) {
			logger.error("用户不存在");
			throw new UserNotFoundException("用户不存在");
		}
		Book book = bookDao.findByBookId(bookId);
		if (book == null) {
			logger.error("笔记本不存在");
			throw new NoteBookNotFoundException("笔记本不存在");
		}
		Note note = new Note();
		note.setCnNoteBody("");
		note.setCnNoteBookId(bookId);
		note.setCnNoteStatusId(1L);
		note.setCnNoteTitle(noteTitle);
		note.setCnNoteTypeId(1L);
		note.setCnUserId(userId);
		
		noteDao.save(note);
		Map map = new HashMap();
		map.put("userId", userId);
		
		note = noteDao.findNotes(map).get(0);
		return note;
	}

	public int delNote(Long noteId) {
		//更新笔记状态
		int rows=noteDao.updateStatus(noteId);
		if (rows==0) {
			logger.error("ID不存在");
			throw new NoteBookNotFoundException("ID不存在");
		}
		return rows;
	}
	
	//笔记编辑区
	public Note editNote(Long noteId) {
		Note note = noteDao.findByNoteId(noteId);
		return note;
	}
	
	public int delNotes(Long... ids) {
		int n=noteDao.deleteNoteById(ids);
		if(n!=ids.length){
			logger.error("ID不存在");
			throw new NoteBookNotFoundException("ID不存在");
		}
		return n;
	}

	//修改保存笔记
	public Note saveNote(Long noteId, String body) {
		Map map = new HashMap();
		map.put("noteId", noteId);
		map.put("body", body);
		noteDao.updateBody(map);
		Note note = noteDao.findByNoteId(noteId);
		return note;
	}
		
	public List<Note> find(String title, String status, String begin, String end, Long userId) {
		Map<String,Object> params
				=new HashMap<String,Object>();
		params.put("userId",userId);
		//判断标题条件,不为空时有效
		if(title!=null && !"".equals(title)){
			params.put("title","%"+title+"%");
		}
		//判断状态条件,不为"全部"时有效
		if(status!=null && !"0".equals(status)){
			params.put("status",status);
		}
		//判断开始日期,不为空有效
		if(begin!=null && !"".equals(begin)){
			//将输入的日期字符串转成long类型数据
			Date beginDate=Date.valueOf(begin);
			params.put("begin",beginDate.getTime());
		}
		//判断结束日期,不为空有效
		if(end!=null && !"".equals(end)){
			Date endDate=Date.valueOf(end);
			params.put("end",endDate.getTime());
		}
		List<Note> list
				=noteDao.findNotes(params);
		return list;
	}

}




