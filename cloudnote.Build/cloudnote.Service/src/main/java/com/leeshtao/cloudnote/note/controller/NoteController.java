package com.leeshtao.cloudnote.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.common.ExceptionController;
import com.leeshtao.cloudnote.note.entity.Note;
import com.leeshtao.cloudnote.note.handler.NoteService;
import com.leeshtao.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/note")
public class NoteController extends ExceptionController{

	@Resource
	private NoteService noteService;
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult listNotes(Long bookId){
		List<Note> books = noteService.listNotes(bookId);
		return new JsonResult(books);
	}
	@RequestMapping("/addNote.do")
	@ResponseBody
	public JsonResult addNote(Long userId, Long bookId, String noteTitle){
		Note note = noteService.addNote(userId, bookId, noteTitle);
		return new JsonResult(note);
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public JsonResult deleteNote(Long noteId){
		int row = noteService.delNote(noteId);
		return new JsonResult(row);
	}
	
	@RequestMapping("/edit.do")
	@ResponseBody
	public JsonResult editNote(Long noteId){
		Note note = noteService.editNote(noteId);
		return new JsonResult(note);
	}
	
	@RequestMapping("/saveNote.do")
	@ResponseBody
	public JsonResult saveNote(Long noteId,String body){
		Note note = noteService.saveNote(noteId,body);
		return new JsonResult(note);
	}
	
	@RequestMapping("/manage.do")
	@ResponseBody
	public JsonResult find(String title, String status, String begin, String end,Long userId){
		List<Note> notes = noteService.find(title, status, begin, end, userId);
		return new JsonResult(notes);
	}
}
















