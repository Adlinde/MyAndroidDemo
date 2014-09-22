package com.oa.action.ssd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.json.JsonConfig;

import com.oa.common.BaseAction;
import com.oa.entity.OaMeeting;
import com.oa.entity.OaUser;
import com.oa.service.IMeetingService;
import com.oa.util.JsonProcessForDic;
import com.oa.util.Page;

public class MeetingAction_ssd extends BaseAction{
	
	Logger log = LogManager.getLogger(MeetingAction_ssd.class);
	
	private IMeetingService service;
	
	private OaMeeting meeting;
	
	private String json;//json�ַ���
	
	private Page realPage=new Page();//ҳ�����
	
	private String page;//ҳ��
	
	private String rows;//ǰ��ÿҳ��ʾ����
	
	
	/**
	 *��ӻ�����
	 * @return
	 */
	public String add(){
		meeting.setMeetingState(1);
		int result=service.save(meeting);
		
		if(result==1){
			json="{\"status\":\"1\",\"msg\":\"��ӻ����ҳɹ�\"}";
			System.out.println("��ӳɹ�");
		}else{
			json="{\"status\":\"2\",\"msg\":\"���ʧ��\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	
	/**
	 *���ؿ�Ԥ��������
	 * @return
	 */
	public String selyesmeeting(){
		
		String hql = "from OaMeeting m where m.meetingState=1";
		//List<OaNotice> notices = service.findAll(hql);
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		service.findAllByPage(hql, realPage);
		
		JsonConfig config=new JsonConfig();
		
		config.setExcludes(new String[]{"oaMeetingPreplots"});
		
		//config.registerJsonValueProcessor(OaUser.class,new JsonProcessForDic());
		
		String json=this.selAllObjByPage(realPage, config);
		
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 *�������л�����
	 * @return
	 */
	public String selallmeeting(){
		
		String hql = "from OaMeeting";
		//List<OaNotice> notices = service.findAll(hql);
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		service.findAllByPage(hql, realPage);
		
		JsonConfig config=new JsonConfig();
		
		config.setExcludes(new String[]{"oaMeetingPreplots"});
		
		config.registerJsonValueProcessor(OaUser.class,new JsonProcessForDic());
		
		String json=this.selAllObjByPage(realPage, config);
		
		System.out.println(json);
		this.exitTxt(json);
		
		return NONE;
	}
	/**
	 *ɾ��������
	 * @return
	 */
	public String del(){
		OaMeeting m=service.selObjById("from OaNotice n where n.uuid=?", meeting.getUuid());
		if(m.getMeetingState()==1){
			int result=service.delete(m);
			if(result==1){
				json = "{\"status\":\"1\",\"msg\":\"�h�������ҳɹ�\"}";
			}else{
				json = "{\"status\":\"2\",\"msg\":\"�h��������ʧ��\"}";
			}
		}
		else{
			json = "{\"status\":\"2\",\"msg\":\"�����ұ�Ԥ��������ɾ��\"}";
		}
        
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return NONE;
	}
	
	
	public IMeetingService getService() {
		return service;
	}
	public void setService(IMeetingService service) {
		this.service = service;
	}
	public OaMeeting getMeeting() {
		return meeting;
	}
	public void setMeeting(OaMeeting meeting) {
		this.meeting = meeting;
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
