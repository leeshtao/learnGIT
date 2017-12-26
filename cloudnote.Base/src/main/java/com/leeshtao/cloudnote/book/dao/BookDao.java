package com.leeshtao.cloudnote.book.dao;

import java.util.List;
import java.util.Map;

import com.leeshtao.cloudnote.book.entity.Book;


public interface BookDao {
	List<Book> findByUserId(Long userId);
	Book findByBookId(Long bookId);
	void save(Book book);
	List<Book> findListByUserId(Long userId);
	Book findByUserIdAndBookName(Map map);
}









