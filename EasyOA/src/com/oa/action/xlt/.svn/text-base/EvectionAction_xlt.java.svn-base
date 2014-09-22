package com.oa.action.xlt;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaDictionary;
import com.oa.entity.OaEvection;
import com.oa.service.IEvectionService;
import com.opensymphony.xwork2.Action;

/**
 * 出差Action类
 * @author Administrator
 *
 */
public class EvectionAction_xlt extends BaseAction {


	Logger log = LogManager.getLogger(EvectionAction_xlt.class);
	
	private IEvectionService service;//出差service
	
	private OaEvection evection;//出差对象
	
	private String json;
	/**
	 * 添加出差申请的方法
	 * 
	 */
	public String add() {
		   
		int row=service.save(evection);
		if(row>0){

		 	json="{\"status\":\"2\",\"msg\":\"添加申请成功\"}";
		}
		else{

		    json="{\"status\":\"1\",\"msg\":\"添加申请失败 \"}";

		}
		
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * 加载所有出差交通工具的方法
	 * @return
	 */
	public String loadVehicle() {

		String hql = "from OaDictionary dic where dic.dictionaryType=4";


		List<OaDictionary> leaveTypeList = service.findAll(hql);

//		JsonConfig config = new JsonConfig();
//		config.setExcludes(new String[] { "oaUsers", "roleAuths" });

		JSONArray arrays = JSONArray.fromObject(leaveTypeList);
		String json = arrays.toString();

		log.debug("json:" + json);

		this.exitTxt(json);
		return Action.NONE;
	}
	



	public IEvectionService getService() {
		return service;
	}

	public void setService(IEvectionService service) {
		this.service = service;
	}

	public OaEvection getEvection() {
		return evection;
	}

	public void setEvection(OaEvection evection) {
		this.evection = evection;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}


}
