package com.leeshtao.cloudnote.book.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leeshtao.cloudnote.book.entity.Book;
import com.leeshtao.cloudnote.book.handler.BookService;
import com.leeshtao.cloudnote.common.ExceptionController;
import com.leeshtao.cloudnote.util.JsonResult;


@Controller
@RequestMapping("/book")
public class BookController extends ExceptionController{

	@Resource
	private BookService bookService;
	@RequestMapping("/loadBooks.do")
	@ResponseBody
	public JsonResult listBooks(Long userId){
		List<Book> books = bookService.listBooks(userId);
		return new JsonResult(books);
	}
	
	@RequestMapping("/addBook.do")
	@ResponseBody
	public JsonResult addBook(Long userId,String bookName){
		Book book = bookService.addBook(userId, bookName);
		return new JsonResult(book);
	}
}




