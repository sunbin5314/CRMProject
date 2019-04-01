package com.test.utils;

import java.util.List;

public class PageBean<T> {
	//��ǰҳ
	private Integer currentPage;
	//�ܼ�¼��
	private Integer totalCount;
	//��ҳ��
	private Integer totalPage;
	//ÿҳ��ʾ�ļ�¼��
	private Integer pageSize;
	//ÿҳ��ʾ����
	private List<T> list;
	//��ʼλ��
	private Integer begin;
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
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
}
