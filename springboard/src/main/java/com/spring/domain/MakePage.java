package com.spring.domain;

public class MakePage {
	private int currPage;
	private int totalCount;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int startBlock;
	private int endBlock;
	private boolean next;
	private boolean prev;
	
	public MakePage(int currPage, int totalCount, int pageSize, int blockSize) {
		this.currPage = currPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calData();
	}
	
	public void calData() {
		startRow = (currPage-1)*pageSize;
		endRow = startRow+pageSize-1;
		
		if(endRow>totalCount) {
			endRow = totalCount;
		}
		
		startBlock = (((currPage-1)/blockSize)*blockSize)+1;
		endBlock = startBlock+blockSize-1;
		
		int totalPage=(totalCount-1)/pageSize+1;
		System.out.println(totalPage);
		if(endBlock>totalPage) {
			endBlock = totalPage;
		}
		prev = (startBlock==1)? false:true;
		next = (endBlock<totalPage)? true:false;
		
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getStartRow() {
		return startRow;
	}

	
	public int getEndRow() {
		return endRow;
	}

	
	public int getStartBlock() {
		return startBlock;
	}

	
	public int getEndBlock() {
		return endBlock;
	}

	
	public boolean isNext() {
		return next;
	}

	public boolean isPrev() {
		return prev;
	}

}
