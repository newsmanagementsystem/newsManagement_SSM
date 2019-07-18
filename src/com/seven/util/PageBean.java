package com.seven.util;

import java.util.ArrayList;

//分页对象
public class PageBean<T> {
	private Integer currentPage; //当前页
	private Integer totalCount;       //总的记录数
	private Integer pageSize;        //每页显示条数
	private Integer totalPage;			//总页数
	private ArrayList<T> list;         //数据集合
	private Integer startRow;    //开始行（主要是为了mysql的limit条件---limit startRow，pageSize;）

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		if(totalCount % pageSize == 0){
			this.totalPage = totalCount/pageSize;
		}else {
			this.totalPage = totalCount/pageSize + 1;
		}

		this.startRow = (currentPage-1)*pageSize;
	}

	public PageBean() {
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"currentPage=" + currentPage +
				", totalCount=" + totalCount +
				", pageSize=" + pageSize +
				", totalPage=" + totalPage +
				", list=" + list +
				", startRow=" + startRow +
				'}';
	}
}
