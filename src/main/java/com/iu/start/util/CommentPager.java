package com.iu.start.util;

public class CommentPager {

	private Long startRow;
	private Long lastRow;
	private Long bookNum;
	private Long page;
	private Long perPage;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	public void getRow() {
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=this.getPage()*this.getPerPage();
	}
	
	public void getNum(Long totalCount) {
		Long totalPage = (long) Math.ceil((double) totalCount/this.getPerPage());
		Long totalBlock = (long) Math.ceil((double) totalPage/this.getPerBlock());
		Long curBlock = (long) Math.ceil((double) this.getPage()/this.getPerBlock());
		
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock * this.getPerBlock();
	}

	public Long getPerBlock() {
		if(this.perBlock==null || this.perBlock<1) {
			this.perBlock = 5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
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
		if(this.perPage == null || this.perPage<1) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
}