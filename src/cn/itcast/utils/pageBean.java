package cn.itcast.utils;

import java.util.List;

public class pageBean {

	//当前页数
	private Integer currentPage;
	//总页数
	private Integer totalPage;
	//总条数
	private Integer totalCount;
	//页面条数
	private Integer pageSize;
	//分页列表数据
	private List list;
	public pageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		//当前页数为空
		if (this.currentPage==null) {
			this.currentPage = 1;
		}
		//当前显示条数为空
		if (this.pageSize==null) {
			this.pageSize = 6;
		}
		//计算总页数
		this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;
		
		//页面超出范围
		//小于一
		if (this.currentPage<1) {
			this.currentPage = 1;
		}
		
		//大于总页数
		if (this.currentPage>this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	//计算起始索引
	public int getStart(){
		
		return (this.currentPage-1)*this.pageSize;
		
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
