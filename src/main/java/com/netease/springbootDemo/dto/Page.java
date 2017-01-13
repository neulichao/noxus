package com.netease.springbootDemo.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = -2023727607665537363L;
	public static final int DEFAULT_PAGESIZE = 10;
	protected List<T> result = Collections.emptyList();
	protected long totalCount = -1L;
	protected int pageNo = 1;
	protected int totalPage = 1;
	protected int pageSize;

	public Page() {
		this.pageSize = 10;
	}

	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResult() {
		return this.result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount == 0)
			this.totalPage = 0;
		else
			this.totalPage = (totalCount % getPageSize() == 0 ? totalCount / getPageSize() : totalCount / getPageSize()
					+ 1);
	}

	public int getPageNo() {
		if (this.pageNo <= 0) {
			this.pageNo = 1;
		}
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void pageNoPlus(int i) {
		this.pageNo += i;
	}

	public static <T> Page<T> getInstantce(int pageNo, int pageSize, Class<T> c) {
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		return page;
	}
}