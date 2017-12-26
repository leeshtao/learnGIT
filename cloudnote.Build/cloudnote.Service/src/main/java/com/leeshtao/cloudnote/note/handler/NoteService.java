package com.leeshtao.cloudnote.note.handler;

import java.util.List;
import java.util.Map;

import com.leeshtao.cloudnote.common.exception.NoteBookNotFoundException;
import com.leeshtao.cloudnote.note.entity.Note;


public interface NoteService {
	List<Note> listNotes(Long bookId)
						throws NoteBookNotFoundException;
	Note addNote(Long userId,Long bookId,String noteTitle);
	//删除笔记方法
	int delNote(Long noteId);
	//批量删除笔记
	int delNotes(Long...ids);
	
	List<Note> find(String title,String status,String begin,String end,Long userId);
	
	Note saveNote(Long noteId,String body);
	
	Note editNote(Long noteId);
}








