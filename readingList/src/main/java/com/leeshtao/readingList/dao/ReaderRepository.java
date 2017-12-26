package com.leeshtao.readingList.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leeshtao.readingList.entity.Reader;

/**
 * 通过JPA持久化读者
 * @author 李世涛
 * @date 2017年12月9日
 * 
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {

	
}
