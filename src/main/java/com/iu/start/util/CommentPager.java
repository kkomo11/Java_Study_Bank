package com.iu.start.util;

public class CommentPager {

	private Long startRow;
	private Long lastRow;
	private Long bookNum;
	private Long page;
	private Long perPage;
	
	public void getRow() {
		startRow=(this.getPage()-1)*this.getPerPage()+1;
		lastRow=this.getPage()*this.getPerPage();
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getBookNum() {
		return bookNum;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
}