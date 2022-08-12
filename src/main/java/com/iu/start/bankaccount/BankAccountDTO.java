package com.iu.start.bankaccount;

import java.sql.Date;

public class BankAccountDTO {
	
	private Integer accountNum;
	private String id;
	private Long bookNum;
	private Date accountDate;
	
	public Integer getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getBookNum() {
		return bookNum;
	}
	
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	
	public Date getAccountDate() {
		return accountDate;
	}
	
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
}
