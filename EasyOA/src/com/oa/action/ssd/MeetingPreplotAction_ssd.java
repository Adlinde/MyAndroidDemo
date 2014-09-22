package com.oa.action.ssd;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaDictionary;
import com.oa.entity.OaMeeting;
import com.oa.entity.OaMeetingPreplot;
import com.oa.entity.OaUser;
import com.oa.service.IDictionaryService;
import com.oa.service.IMeetingPreplotService;
import com.oa.util.JsonProcessForDic;
import com.oa.util.JsonProcessForMeeting;
import com.oa.util.JsonProcessForUser;
import com.oa.util.Page;

/**
 * 会议室申请Action类
 * 
 * @author Administrator
 * 
 */
public class MeetingPreplotAction_ssd extends BaseAction{
	
	Logger log = LogManager.getLogger(MeetingPreplotAction_ssd.class);
	
	private IMeetingPreplotService service;// 会议室申请service
	
	private OaMeetingPreplot meetingPreplot;// 会议室申请entity
	
	private IDictionaryService dservice;// 会议室service
	
	private String json;//json字符串
	
	private Page realPage=new Page();//页码对象
	
	private String page;//页数
	
	private String rows;//前端每页显示数量
	
	/**
	 * 会议室类型加载
	 * @return
	 */
	public String loadMeetingType()
	{
		String hql = "from OaDictionary dic where dic.dictionaryType=5";
		List<OaDictionary> meetingPreplotTypeList = dservice.findAll(hql, null);
		JSONArray arrays = JSONArray.fromObject(meetingPreplotTypeList);
		String json = arrays.toString();
		log.debug("json:" + json);
		this.exitTxt(json);		
		return NONE;
	}
	
	/**
	 * 会议室申请添加
	 * @return
	 */
	public String add(){
		OaUser user=(OaUser) this.getFromSession("currentUser");
		meetingPreplot.setOaUserByRecorder(user);
		meetingPreplot.setPreplotTime(new Date());
        int result=service.save(meetingPreplot);
		
		if(result==1){
			json="{\"st\":\"1\",\"msg\":\"申请成功\"}";
		}else{
			json="{\"st\":\"2\",\"msg\":\"申请失败\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	
	
	/**
	 * 已申请会议室列表
	 * @return
	 */
	public String selappmeeting(){
		
		String hql = "from OaMeetingPreplot ";
		//List<OaNotice> notices = service.findAll(hql);
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		service.findAllByPage(hql, realPage);
		
		JsonConfig config=new JsonConfig();
		
		config.registerJsonValueProcessor(OaMeeting.class,new JsonProcessForMeeting());
		config.registerJsonValueProcessor(OaUser.class,new JsonProcessForUser());
		config.registerJsonValueProcessor(OaDictionary.class,new JsonProcessForDic());
		
		String json=this.selAllObjByPage(realPage, config);
		
		System.out.println(json);
		this.exitTxt(json);
		
		return NONE;
	}
	
	public IMeetingPreplotService getService() {
		return service;
	}
	public void setService(IMeetingPreplotService service) {
		this.service = service;
	}
	public OaMeetingPreplot getMeetingPreplot() {
		return meetingPreplot;
	}
	public void setMeetingPreplot(OaMeetingPreplot meetingPreplot) {
		this.meetingPreplot = meetingPreplot;
	}
	public IDictionaryService getDservice() {
		return dservice;
	}
	public void setDservice(IDictionaryService dservice) {
		this.dservice = dservice;
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
