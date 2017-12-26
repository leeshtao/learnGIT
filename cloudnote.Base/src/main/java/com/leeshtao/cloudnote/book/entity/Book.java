package com.leeshtao.cloudnote.book.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.leeshtao.cloudnote.common.entity.SqlBase;

public class Book extends SqlBase implements Serializable{

	private static final long serialVersionUID = 5961513720488159332L;
	private Long cnUserId;
	private Long cnNoteBookTypeId;
	private String cnNoteBookName;
	
	public Book(){
		
	}

	public Long getCnUserId() {
		return cnUserId;
	}

	public void setCnUserId(Long cnUserId) {
		this.cnUserId = cnUserId;
	}

	public Long getCnNoteBookTypeId() {
		return cnNoteBookTypeId;
	}

	public void setCnNoteBookTypeId(Long cnNoteBookTypeId) {
		this.cnNoteBookTypeId = cnNoteBookTypeId;
	}

	public String getCnNoteBookName() {
		return cnNoteBookName;
	}

	public void setCnNoteBookName(String cnNoteBookName) {
		this.cnNoteBookName = cnNoteBookName;
	}


	
}







