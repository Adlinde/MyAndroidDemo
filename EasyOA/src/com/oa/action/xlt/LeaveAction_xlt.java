package com.oa.action.xlt;

import java.util.List;

import net.sf.json.JSONArray;
import com.oa.common.BaseAction;
import com.oa.entity.OaDictionary;
import com.oa.entity.OaTbLeave;
import com.oa.service.ILeaveService;
import com.opensymphony.xwork2.Action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * ���Action��
 * 
 * @author Administrator
 * 
 */
public class LeaveAction_xlt extends BaseAction {

	Logger log = LogManager.getLogger(LeaveAction_xlt.class);

	private ILeaveService service;// ���service

	private OaTbLeave leave;// ��ٶ���
	
	private String json;

	/**
	 * ����������͵ķ���
	 * @return
	 */
	public String loadType() {

		String hql = "from OaDictionary dic where dic.dictionaryType=1";

		List<OaDictionary> leaveTypeList = service.findAll(hql);

//		JsonConfig config = new JsonConfig();
//		config.setExcludes(new String[] { "oaUsers", "roleAuths" });

		JSONArray arrays = JSONArray.fromObject(leaveTypeList);
		String json = arrays.toString();

		log.debug("json:" + json);

		this.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * ����������ķ���
	 * 
	 * @return
	 */
	public String add() {
   
		int row=service.save(leave);
		if(row>0){

			json="{\"status\":\"2\",\"msg\":\"�������ɹ�\"}";

		}
		else{

			json="{\"status\":\"1\",\"msg\":\"�������ʧ�� \"}";

		}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}
	

	public OaTbLeave getLeave() {
		return leave;
	}

	public void setLeave(OaTbLeave leave) {
		this.leave = leave;
	}



	public ILeaveService getService() {
		return service;
	}

	public void setService(ILeaveService service) {
		this.service = service;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}


}
