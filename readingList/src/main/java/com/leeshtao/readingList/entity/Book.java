package com.leeshtao.readingList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="READER")
	private String reader;
	@Column(name="ISBN")
	private String isbn;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="DESCRIPTION")
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReader() {
		return reader;
	}
	public void setReader(String reader) {
		this.reader = reader;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
