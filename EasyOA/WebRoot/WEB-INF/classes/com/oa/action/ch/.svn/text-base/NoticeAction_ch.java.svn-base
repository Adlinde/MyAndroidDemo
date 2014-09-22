package com.oa.action.ch;

import java.util.List;


import com.oa.common.BaseAction;
import com.oa.entity.OaNotice;
import com.oa.service.INoticeService;

import com.oa.util.Page;

public class NoticeAction_ch extends BaseAction {
	private INoticeService noticeService;//业务对象
	
	private OaNotice notice;//实体对象
	
	private Page pageData;//页面对象
	
	private Integer page;
	
	private String json;//json对象
	public NoticeAction_ch(){
		System.out.println("NoticeAction_ch被初始化");
	}
	public String toList(){
		if(page!=null){
			pageData.setPageIndex(page);
		}
		noticeService.findAllByPage("from OaNotice o where o.oaUserByReceiveOaUserUuid is null", pageData);
		List<OaNotice> notices=pageData.getList();
		json="{\"total\":"+pageData.getPageCount()+",\"rows\":[";
		for (OaNotice on : notices) {
			json+="{\"title\":\""+on.getTitle()+"\",\"status\":\""+on.getStatus()+"\",\"pubdate\":\""+on.getBegindate()+"\",\"content\":\""+on.getContent()+"\",\"oaUserByUserid\":\""+on.getOaUserByUserid().getName()+"\"},";
			
		}
		json=this.trimLastDot(json);
		json+="]}";
	System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	
	
	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public OaNotice getNotice() {
		return notice;
	}

	public void setNotice(OaNotice notice) {
		this.notice = notice;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	public Page getPageData() {
		return pageData;
	}
	public void setPageData(Page pageData) {
		this.pageData = pageData;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
}
