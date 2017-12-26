package com.leeshtao.cloudnote.note.entity;

import java.io.Serializable;

import com.leeshtao.cloudnote.common.entity.SqlBase;

public class Note extends SqlBase implements Serializable{

	private static final long serialVersionUID = 5001773334178344366L;
	private Long cnNoteBookId;
	private Long cnUserId;
	private Long cnNoteStatusId;
	private Long cnNoteTypeId;
	private String cnNoteTitle;
	private String cnNoteBody;
	public Note(){
		
	}
	public Long getCnNoteBookId() {
		return cnNoteBookId;
	}
	public void setCnNoteBookId(Long cnNoteBookId) {
		this.cnNoteBookId = cnNoteBookId;
	}
	public Long getCnUserId() {
		return cnUserId;
	}
	public void setCnUserId(Long cnUserId) {
		this.cnUserId = cnUserId;
	}
	public Long getCnNoteStatusId() {
		return cnNoteStatusId;
	}
	public void setCnNoteStatusId(Long cnNoteStatusId) {
		this.cnNoteStatusId = cnNoteStatusId;
	}
	public Long getCnNoteTypeId() {
		return cnNoteTypeId;
	}
	public void setCnNoteTypeId(Long cnNoteTypeId) {
		this.cnNoteTypeId = cnNoteTypeId;
	}
	public String getCnNoteTitle() {
		return cnNoteTitle;
	}
	public void setCnNoteTitle(String cnNoteTitle) {
		this.cnNoteTitle = cnNoteTitle;
	}
	public String getCnNoteBody() {
		return cnNoteBody;
	}
	public void setCnNoteBody(String cnNoteBody) {
		this.cnNoteBody = cnNoteBody;
	}
	
}








