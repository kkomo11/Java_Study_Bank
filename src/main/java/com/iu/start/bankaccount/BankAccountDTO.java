package com.iu.start.bankaccount;

import java.sql.Date;

import com.iu.start.bankbook.BankBookDTO;

public class BankAccountDTO {
	
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}

	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}

	public Long getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(Long accountNum) {
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
