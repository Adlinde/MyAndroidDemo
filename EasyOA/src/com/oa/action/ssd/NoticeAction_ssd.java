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

	private INoticeService service;//ͨ��ҵ��

	private OaNotice notice;//ͨ��ʵ����

	private String json;//json�ַ���
	
	private Page realPage=new Page();//ҳ�����
	
	private String page;//ҳ��
	
	private String rows;//ǰ��ÿҳ��ʾ����
	
	/**
	 * ����ͨ��
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
			json="{\"st\":\"1\",\"msg\":\"���ӳɹ�\"}";
		}else{
			json="{\"st\":\"2\",\"msg\":\"����ʧ��\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}

	/**
	 * ��ʾ����ͨ��
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
//		String status="һ��";
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
	 * ɾ��ͨ��
	 * 
	 * @return
	 */
	public String del() {
		
		OaNotice no=service.selObjById("from OaNotice n where n.uuid=?", notice.getUuid());
		
		int result=service.delete(no);
		
		if(result==1){
			json = "{\"status\":\"1\",\"msg\":\"�h��ͨ��ɹ�\"}";
		}else{
			json = "{\"status\":\"2\",\"msg\":\"�h��ͨ��ʧ��\"}";
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