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
 * ������ϢAction
 * @author Administrator
 *
 */
public class CarAction_ssd extends BaseAction{
	
	Logger log = LogManager.getLogger(CarAction_ssd.class);
	
	private ICarService service;//����service
	
	private IDictionaryService dservice;//�ֵ�service
	
	private OaCar car;//������Ϣʵ��
	
	private String json;//json�ַ���
	
	private Page realPage=new Page();//ҳ�����
	
	private String page;//ҳ��
	
	private String rows;//ǰ��ÿҳ��ʾ����
	
	/**
	 * �ֵ���м��س�������
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
	 * ��ӳ�����Ϣ
	 * @return
	 */
	public String add(){
		car.setState(1);
		int result =service.save(car);
		if(result==1){
			json="{\"st\":\"1\",\"msg\":\"selallCar.action\"}";
			System.out.println("��ӳɹ�");
		}else{
			json="{\"st\":\"2\",\"msg\":\"���ʧ��\"}";
		}
		log.debug("json:" + json);
		System.out.println(json);
		this.exitTxt(json);
		return NONE;
	}
	/**
	 * ��ȡ���г�����Ϣ
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
	 * ɾ��������Ϣ
	 * @return
	 */
	public String del(){
		OaCar c=service.selObjById("from OaCar c where c.number=?", car.getNumber());
		int result=service.delete(c);
		if(result==1){
			json="{\"status\":\"1\",\"msg\":\"ɾ���ɹ� \"}";
		}else{
			json="{\"status\":\"2\",\"msg\":\"ɾ��ʧ�� \"}";
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
