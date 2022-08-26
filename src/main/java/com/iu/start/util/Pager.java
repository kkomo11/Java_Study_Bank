package com.iu.start.util;

public class Pager {
	
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	
	// 이전, 다음 블럭의 유무
	private boolean pre;
	private boolean next;
	
	// 검색 컬럼, 검색어
	private String kind;
	private String search;
	
	public Pager() {
		// TODO Auto-generated constructor stub
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	/**
	 * mapper로 갈 변수 값 구하는 메소드
	 */
	public void getRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	/**
	 * jsp로 갈 변수 값 구하는 메소드
	 * @param totalCount DB에 있는 글 개수
	 */
	public void getNum(Long totalCount) {
		// 총 글 개수
		// 최대 페이지 수
		Long totalPage = (long) Math.ceil((double) totalCount/this.getPerPage());
		
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		// 최대 블럭 수
		Long totalBlock = (long) Math.ceil((double) totalPage/this.getPerBlock());
		// 현재 블럭이 몇 번째인지
		Long curBlock = (long) Math.ceil((double) this.getPage()/this.getPerBlock());
		// 현재 블럭 startNum lastNum
		this.startNum = (curBlock-1)*this.getPerBlock() + 1;
		this.lastNum = curBlock*this.getPerBlock();
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		if(curBlock > 1) pre=true; // 현재 블럭이 1보다 클 경우 이전 버튼 필요
		if(curBlock < totalBlock) next=true; // 현재 블럭이 최대 블럭보다 작을 경우 다음 버튼필요
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
	public Long getPerPage() {
		if(this.perPage == null) this.perPage=10L;
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		if(this.perBlock == null) this.perBlock=5L;
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getPage() {
		if(this.page == null || this.page <= 0) page=1L;
		
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}
	
	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) this.search="";
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
