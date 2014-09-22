package com.oa.action.ssd;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaCar;
import com.oa.entity.OaDictionary;
import com.oa.entity.OaUser;
import com.oa.service.ICarService;
import com.oa.service.IDictionaryService;
import com.oa.util.JsonProcessForDic;
import com.oa.util.Page;
/**
 * 车辆信息Action
 * @author Administrator
 *
 */
public class CarAction_ssd extends BaseAction{
	
	Logger log = LogManager.getLogger(CarAction_ssd.class);
	
	private ICarService service;//车辆service
	
	private IDictionaryService dservice;//字典service
	
	private OaCar car;//车辆信息实体
	
	private String json;//json字符串
	
	private Page realPage=new Page();//页码对象
	
	private String page;//页数
	
	private String rows;//前端每页显示数量
	
	/**
	 * 字典表中加载车辆类型
	 * @return
	 */
	public String loadType(){
		
		String hql = "from OaDictionary dic where dic.dictionaryType=2";
		List<OaDictionary> carTypeList = dservice.findAll(hql, null);
		JSONArray arrays = JSONArray.fromObject(carTypeList);
		String json = arrays.toString();
		log.debug("json:" + json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 * 添加车辆信息
	 * @return
	 */
	public String add(){
		car.setState(1);
		int result =service.save(car);
		if(result==1){
			json="{\"st\":\"1\",\"msg\":\"selallCar.action\"}";
			System.out.println("添加成功");
		}else{
			json="{\"st\":\"2\",\"msg\":\"添加失败\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 * 读取所有车辆信息
	 * @return
	 */
	public String selall(){
		
		String hql = "from OaCar c order by c.state desc";
		//List<OaNotice> notices = service.findAll(hql);
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		service.findAllByPage(hql, realPage);
		
		JsonConfig config=new JsonConfig();
		
		config.setExcludes(new String[]{"oaApplyCars"});
		
		config.registerJsonValueProcessor(OaDictionary.class,new JsonProcessForDic());
		
		String json=this.selAllObjByPage(realPage, config);
		
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 * 删除车辆信息
	 * @return
	 */
	public String del(){
		OaCar c=service.selObjById("from OaCar c where c.number=?", car.getNumber());
		int result=service.delete(c);
		if(result==1){
			json="{\"status\":\"1\",\"msg\":\"删除成功 \"}";
		}else{
			json="{\"status\":\"2\",\"msg\":\"删除失败 \"}";
		}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return NONE;
	}

	public ICarService getService() {
		return service;
	}

	public void setService(ICarService service) {
		this.service = service;
	}

	public IDictionaryService getDservice() {
		return dservice;
	}

	public void setDservice(IDictionaryService dservice) {
		this.dservice = dservice;
	}

	public OaCar getCar() {
		return car;
	}

	public void setCar(OaCar car) {
		this.car = car;
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
