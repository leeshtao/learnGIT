package com.leeshtao.cloudnote.book.handler;

import java.util.List;

import com.leeshtao.cloudnote.book.entity.Book;
import com.leeshtao.cloudnote.common.exception.UserNotFoundException;


public interface BookService {
	List<Book> listBooks(Long userId) 
			throws UserNotFoundException;
	Book addBook(Long userId,String bookName)
			throws UserNotFoundException;
}
