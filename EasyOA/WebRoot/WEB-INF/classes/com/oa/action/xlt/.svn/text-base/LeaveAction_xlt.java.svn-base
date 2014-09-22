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
 * 请假Action类
 * 
 * @author Administrator
 * 
 */
public class LeaveAction_xlt extends BaseAction {

	Logger log = LogManager.getLogger(LeaveAction_xlt.class);

	private ILeaveService service;// 请假service

	private OaTbLeave leave;// 请假对象
	
	private String json;

	/**
	 * 加载请假类型的方法
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
	 * 添加请假申请的方法
	 * 
	 * @return
	 */
	public String add() {
   
		int row=service.save(leave);
		if(row>0){

			json="{\"status\":\"2\",\"msg\":\"添加申请成功\"}";

		}
		else{

			json="{\"status\":\"1\",\"msg\":\"添加申请失败 \"}";

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
