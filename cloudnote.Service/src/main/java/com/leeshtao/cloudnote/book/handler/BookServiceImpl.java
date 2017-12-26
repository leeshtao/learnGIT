package com.leeshtao.cloudnote.book.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BooleanDeserializer;
import com.leeshtao.cloudnote.book.dao.BookDao;
import com.leeshtao.cloudnote.book.entity.Book;
import com.leeshtao.cloudnote.common.exception.NoteBookNotFoundException;
import com.leeshtao.cloudnote.common.exception.UserNotFoundException;
import com.leeshtao.cloudnote.user.dao.UserDao;
import com.leeshtao.cloudnote.user.entity.User;

@Service("bookService")
public class BookServiceImpl implements BookService{
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Resource
	private UserDao userDao;
	@Resource
	private BookDao bookDao;
	
	public List<Book> listBooks(Long userId) throws UserNotFoundException {
		if(userId==null){
			throw new UserNotFoundException("User ID不能为空");
		}
		User user = userDao.findByUserId(userId);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		List<Book> list=bookDao.findByUserId(userId);
		
		return list;
	}

	public Book addBook(Long userId, String bookName) throws UserNotFoundException {
		if(userId==null){
			throw new UserNotFoundException("User ID不能为空");
		}
		User user =userDao.findByUserId(userId);
		if(user==null){
			logger.error("用户不存在");
			throw new UserNotFoundException("用户不存在");
		}
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("bookName", bookName);
		Book book = bookDao.findByUserIdAndBookName(map);
		if (book!=null) {
			logger.error("笔记本名不能重复");
			throw new NoteBookNotFoundException("笔记本名不能重复");
		}
		book=new Book();
		book.setCnUserId(userId);
		book.setCnNoteBookName(bookName);
		book.setCnNoteBookTypeId(1L);
		bookDao.save(book);
		book = bookDao.findListByUserId(userId).get(0);
		return book;
	}
}






