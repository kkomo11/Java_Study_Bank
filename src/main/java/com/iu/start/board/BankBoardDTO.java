package com.iu.start.board;

import java.sql.Date;

public class BankBoardDTO {
	
	private Integer no;
	private String title;
	private String contents;
	private String id;
	private Date writeDate;
	private Integer hit;
	
	public Integer getNo() {
		return no;
	}
	
	public void setNo(Integer no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public Integer getHit() {
		return hit;
	}
	
	public void setHit(Integer hit) {
		this.hit = hit;
	}
}