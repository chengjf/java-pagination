package com.chengjf.page.service;

import java.util.List;

public class Page<T> {

	private List<T> dataList;
	private int dataCount;
	private int pageNum;
	private int perPageCount;
	private int currPageNum;

	public Page() {

	}

	public Page(List<T> dataList, int dataCount, int pageNum, int perPageCount,
			int currPageNum) {
		super();
		this.dataList = dataList;
		this.dataCount = dataCount;
		this.pageNum = pageNum;
		this.perPageCount = perPageCount;
		this.currPageNum = currPageNum;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPerPageCount() {
		return perPageCount;
	}

	public void setPerPageCount(int perPageCount) {
		this.perPageCount = perPageCount;
	}

	public int getCurrPageNum() {
		return currPageNum;
	}

	public void setCurrPageNum(int currPageNum) {
		this.currPageNum = currPageNum;
	}

}
