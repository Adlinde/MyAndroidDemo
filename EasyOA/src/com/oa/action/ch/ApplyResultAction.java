package com.oa.action.ch;

import java.util.List;

import com.oa.common.BaseAction;
import com.oa.entity.OaApplyResult;
import com.oa.service.IApplyResultService;
import com.oa.util.Page;

public class ApplyResultAction extends BaseAction {
	private OaApplyResult ar;//实体对象
	
	private IApplyResultService arService;//审核业务对象
	
	private Page pageData;//页面数据对象
	
	private Integer page;//接收前台easyUi传过来的当前面索引
	
	private int total;
	
	private String json;
	
	public ApplyResultAction(){
		System.out.println("ApplyResultAction被初始化...*****");
	}
	/**
	 * 找出待处理任务
	 * @return
	 */
	public String toWaitList(){
		if(page!=null){
			pageData.setPageIndex(page);
		}
		List<OaApplyResult> oars=null;
	
		oars= arService.findAll("from OaApplyResult o where o.applyResult is null",pageData);
		
	
		 json="{\"total\":"+total+",\"rows\":[";
		for (OaApplyResult o : oars) {
			json+="{\"title\":\""+o.getApplyTitle()+"\",\"startTime\":\""+o.getBeginTime()+"\",\"operation\":\"<a href='#' class='easyui-linkbutton' data-options='iconCls:'icon-search''>审核</a>\"},";
		}
		if(json.charAt(json.length()-1)==','){
			json=json.substring(0,json.length()-1);
		}
		json+="]}";
System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		int result=arService.save(ar);
		this.exitTxt("{\"result\":\""+result+"\"}");
		return NONE;
	}
	
	public OaApplyResult getAr() {
		return ar;
	}

	public void setAr(OaApplyResult ar) {
		this.ar = ar;
	}

	public IApplyResultService getArService() {
		return arService;
	}

	public void setArService(IApplyResultService arService) {
		this.arService = arService;
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
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
