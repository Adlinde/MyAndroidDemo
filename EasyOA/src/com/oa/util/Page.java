package com.oa.util;

import java.util.List;

/**
 * ͨ�÷�ҳ����
 * 
 * @author Administrator
 * 
 */
public class Page {
	private int pageSize=10;// ÿҳ����
	
	private int pageIndex=1;// ҳ����
	
	private int pageCount;// ����
	
	private int totalPage;// ��ҳ��
	
	private List list;//��ʾ������Ϣ
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalPage() {
 
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		
	}


	
	
}
