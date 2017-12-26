package com.leeshtao.cloudnote.note.dao;

import java.util.List;
import java.util.Map;

import com.leeshtao.cloudnote.note.entity.Note;


public interface NoteDao {
	List<Note> findByBookId(Long bookId);
	int save(Note note);
	Note findByNoteId(Long noteId);
	//删除笔记方法
	int updateStatus(Long noteId);
	//批量删除笔记
	int deleteNoteById(Long... ids);
	
	List<Note> findNotes(Map params);
	
	void updateBody(Map map);
}








