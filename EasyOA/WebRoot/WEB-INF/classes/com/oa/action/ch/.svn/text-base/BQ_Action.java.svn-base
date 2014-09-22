package com.oa.action.ch;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaBqTable;
import com.oa.service.IBqtableService;
import com.oa.util.Page;

public class BQ_Action extends BaseAction {
	Logger logger=LogManager.getLogger(BQ_Action.class);
	
	private OaBqTable bq;
	
	private IBqtableService bqService;
	
	private Page pageData;
	
	private Integer page;//接收前台传过来的页面索引
	
	private BQ_Action(){
		System.out.println("BQ_Action被初始化....*****");
	}
	
	public String toList(){
		
		if(page!=null){
			pageData.setPageIndex(page);
		}
		List<OaBqTable> bqs=null;
		
		  bqs=bqService.findAll("from OaBqTable o order by o.bqDate desc",pageData);
		
		
			
		
		String json="{\"total\":"+pageData.getPageCount()+",\"rows\":[";
		if(bqs.size()>0 && bqs!=null){
			boolean tmp=false;
			for (OaBqTable o : bqs) {
				json+="{\"title\":\""+o.getBqTitle()+"\",\"content\":\""+o.getBqContent()+"\",\"startTime\":\""+o.getBqDate()+"\"},";
				tmp=true;
			}
			if(tmp){
				json=json.substring(0,json.length()-1);
			}
		}
		json+="]}";
System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
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

	public OaBqTable getBq() {
		return bq;
	}

	public void setBq(OaBqTable bq) {
		this.bq = bq;
	}

	public IBqtableService getBqService() {
		return bqService;
	}

	public void setBqService(IBqtableService bqService) {
		this.bqService = bqService;
	}
}
  
