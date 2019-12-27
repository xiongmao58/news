package com.pyk.model;

import java.util.List;

public class PageBean<T> {
	private int pageCode;// 当前页
	private int totalCount;// 总记录数
	private int pageSize;// 每页显示的记录数
	private List<T> beanList;// 显示的数据

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	// 获取总页数
	public int getTotalPage() {
		// 总页数 = 总记录数（totalCount） / 每页显示记录数 (pageSize)
		int totalPage = totalCount / pageSize;
		if (totalCount % pageSize == 0) {
			return totalPage;
		} else {
			return totalPage+1;
		}

	}
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	@Override
	public String toString() {
		return "PageBean [pageCode=" + pageCode + ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", beanList=" + beanList + "]";
	}

}
