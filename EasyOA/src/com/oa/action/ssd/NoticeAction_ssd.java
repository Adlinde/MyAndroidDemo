package com.oa.action.ssd;
import java.util.Date;

import net.sf.json.JsonConfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaNotice;
import com.oa.entity.OaUser;
import com.oa.service.INoticeService;
import com.oa.util.JsonProcessForDatejson;
import com.oa.util.JsonProcessForState;
import com.oa.util.JsonProcessForUser;
import com.oa.util.Page;

public class NoticeAction_ssd extends BaseAction {

	Logger log = LogManager.getLogger(NoticeAction_ssd.class);

	private INoticeService service;//通告业务

	private OaNotice notice;//通告实体类

	private String json;//json字符串
	
	private Page realPage=new Page();//页码对象
	
	private String page;//页数
	
	private String rows;//前端每页显示数量
	
	/**
	 * 添加通告
	 * 
	 * @return
	 */

	public String add() {

		System.out.println("NoticeAction_ssd..........");
		OaUser user=(OaUser) this.getFromSession("currentUser");
		notice.setOaUserByUserid(user);
		notice.setPubdate(new Date());
		int result=service.save(notice);
		
		if(result==1){
			json="{\"st\":\"1\",\"msg\":\"添加成功\"}";
		}else{
			json="{\"st\":\"2\",\"msg\":\"添加失败\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}

	/**
	 * 显示所有通告
	 * 
	 * @return
	 */
	public String selallnotice() {
		String hql = "from OaNotice n where sysdate() between n.begindate and n.enddate order by status desc,pubdate desc";
		//List<OaNotice> notices = service.findAll(hql);
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		service.findAllByPage(hql, realPage);
		
		JsonConfig config=new JsonConfig();
		//config.registerJsonValueProcessor(Integer.class,new JsonProcessForState());
		config.registerJsonValueProcessor(OaUser.class,new JsonProcessForUser());
		config.registerJsonValueProcessor(Date.class,new JsonProcessForDatejson());
		
		String json=this.selAllObjByPage(realPage, config);
//		String json = "[";
//		String status="一般";
//		for (OaNotice no : notices) {
//			
//			json += "{\"uuid\":\"" + no.getUuid()
//					+ "\",\"title\":\"" + no.getTitle()
//					+ "\",\"status\":\""+ no.getStatus()
//					+ "\",\"pubdate\":\"" + no.getPubdate()
//					+ "\",\"content\":\"" + no.getContent()
//					+ "\",\"pubuser\":\"" + no.getOaUserByUserid().getName()
//					+ "\"},";
//		}
//		if (json.lastIndexOf(",") > 0)
//			json = json.substring(0, json.length() - 1);
//
//		json += "]";
//			
		System.out.println(json);
			this.exitTxt(json);
		return NONE;
	}

	/**
	 * 删除通告
	 * 
	 * @return
	 */
	public String del() {
		
		OaNotice no=service.selObjById("from OaNotice n where n.uuid=?", notice.getUuid());
		
		int result=service.delete(no);
		
		if(result==1){
			json = "{\"status\":\"1\",\"msg\":\"刪除通告成功\"}";
		}else{
			json = "{\"status\":\"2\",\"msg\":\"刪除通告失败\"}";
		}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return NONE;
	}

	public OaNotice getNotice() {
		return notice;
	}

	public void setNotice(OaNotice notice) {
		this.notice = notice;
	}

	public INoticeService getService() {
		return service;
	}

	public void setService(INoticeService service) {
		this.service = service;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Page getRealPage() {
		return realPage;
	}

	public void setRealPage(Page realPage) {
		this.realPage = realPage;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}


}
