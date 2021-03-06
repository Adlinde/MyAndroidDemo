package com.oa.action.ssd;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import com.oa.common.BaseAction;
import com.oa.entity.OaApplyCar;
import com.oa.entity.OaCar;
import com.oa.service.IApplyCarService;
import com.oa.service.ICarService;
import com.opensymphony.xwork2.Action;

public class ApplyCarAction_ssd extends BaseAction{
	
	Logger log = LogManager.getLogger(ApplyCarAction_ssd.class);
	
	private IApplyCarService service;
	
	private ICarService carservice;
	
	private OaApplyCar applycar;
	
	private String json;
	
	/**
	 * ���س�����ŵ�����Ԥ����
	 * @return
	 */
	public String loadCarnum(){
		
		String hql = "from OaCar c where c.state=1";
		List<OaCar> carList = carservice.findAll(hql, null);

		JsonConfig config = new JsonConfig();
	     config.setExcludes(new String[] { "oaApplyCars" ,"oaDictionary"});
	     
		JSONArray arrays = JSONArray.fromObject(carList,config);
		
		String json = arrays.toString();

		log.debug("json:" + json);

		this.exitTxt(json);
		
		return NONE;
	}
	/**
	 * ����������Ϣ����
	 * @return
	 */	
	public String add()
	{
		int result =service.save(applycar);
		if(result>0){
			OaCar c=carservice.selObjById("from OaCar C where C.number=?",applycar.getOaCar().getNumber());
			c.setState(0);
			carservice.update(c);
			json="{\"status\":\"1\",\"msg\":\"����ɹ� \"}";
		}else{
			json="{\"status\":\"2\",\"msg\":\"����ʧ�� \"}";
			
		}	
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return NONE;
	}
	
	public IApplyCarService getService() {
		return service;
	}

	public void setService(IApplyCarService service) {
		this.service = service;
	}

	public ICarService getCarservice() {
		return carservice;
	}

	public void setCarservice(ICarService carservice) {
		this.carservice = carservice;
	}

	public OaApplyCar getApplycar() {
		return applycar;
	}

	public void setApplycar(OaApplyCar applycar) {
		this.applycar = applycar;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}

	
}
