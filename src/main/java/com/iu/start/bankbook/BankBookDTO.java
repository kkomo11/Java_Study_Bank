package com.iu.start.bankbook;

public class BankBookDTO {
	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer booksale;
	
	public Long getBookNum() {
		return bookNum;
	}
	
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public Double getBookRate() {
		return bookRate;
	}
	
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	
	public Integer getBooksale() {
		return booksale;
	}
	
	public void setBooksale(Integer booksale) {
		this.booksale = booksale;
	}	
}