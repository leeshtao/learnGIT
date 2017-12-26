package com.leeshtao.cloudnote.share.entity;

import java.io.Serializable;

import com.leeshtao.cloudnote.common.entity.SqlBase;

public class Share extends SqlBase implements Serializable{

	private static final long serialVersionUID = -2587573855174439272L;
	private String cnShareTitle;
	private String cnShareBody;
	private Long cnNoteId;
	public Share(){
		
	}
	public String getCnShareTitle() {
		return cnShareTitle;
	}
	public void setCnShareTitle(String cnShareTitle) {
		this.cnShareTitle = cnShareTitle;
	}
	public String getCnShareBody() {
		return cnShareBody;
	}
	public void setCnShareBody(String cnShareBody) {
		this.cnShareBody = cnShareBody;
	}
	public Long getCnNoteId() {
		return cnNoteId;
	}
	public void setCnNoteId(Long cnNoteId) {
		this.cnNoteId = cnNoteId;
	}
	
	
}






