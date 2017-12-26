package com.leeshtao.cloudnote.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlBase {

	protected Long id;
	protected String description;
	protected Integer status;
	protected Integer createBy;
	protected String createDate;
	protected Integer lastUpdateBy;
	protected String lastUpdateDate;
	protected Integer isValid;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public SqlBase() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		
		this.createDate = format.format(createDate);
	}
	public Integer getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate != null ? format.format(lastUpdateDate) : null;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	
	
	
}
