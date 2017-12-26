package com.leeshtao.readingList.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leeshtao.readingList.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

	List<Book> findByReader(String reader);
}
