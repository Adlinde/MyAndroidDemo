package com.oa.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.oa.entity.OaDept;
import com.oa.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 通用BaseActin类
 * 
 * @author Administrator
 * 
 */
public class BaseAction extends ActionSupport {

	/**
	 * 通用的request存值方法
	 * 
	 * @param key
	 * @param value
	 */
	public void putInRequest(String key, Object value) {
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put(key, value);
	}

	/**
	 * 通用的session存值方法
	 * 
	 * @param key
	 * @param value
	 */
	public void putInSession(String key, Object value) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(key, value);
	}

	/**
	 * 通用的session取值方法
	 * 
	 * @param name
	 * @return
	 */
	public Object getFromSession(String name) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session.get(name);
	}

	/**
	 * 通用的提交文本的方法
	 * 
	 * @param name
	 * @return
	 */

	public void exitTxt(String txt) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 拼接部门json对象
	 * @param list
	 * @return
	 */
	public String mkDeptJson(List<OaDept> list){
		String json="[";
		for (OaDept oaDept : list) {
			json+=getDeptJson(oaDept);
		}
		json=trimLastDot(json);
		json+="]";
		return json;
	}
	
	/**
	 * 通过迭代方式组装一个或多个json对象
	 * @param oaDept
	 * @return
	 */
	public String getDeptJson(OaDept oaDept){
		String json="{\"id\":\""+oaDept.getUuid()+"\",\"text\":\""+oaDept.getDeptName()+"\"";
		Set<OaDept> set=oaDept.getOaDepts();
		if(set.size()>0){
			json+=",\"children\":[";
			for (OaDept oaDept2 : set) {
				json+=getDeptJson(oaDept2);
			}
			json=trimLastDot(json);
			json+="]";
		}
		json+="},";
		return json;
	}
	
	/**
	 * 切除json最后一个,号
	 * @param json
	 * @return
	 */
	public String trimLastDot(String json){
		String result=json;
		if(json!=null && json.length()>0){
			char lastCharr=json.charAt(json.length()-1);
			if(lastCharr==','){
				result=json.substring(0,json.length()-1);
			}
		}
		return result;
	}
	
	/**
	 * 获取根目录的方法
	 * @return
	 */
	public String applicationpath(){
		String appPath = ServletActionContext.getServletContext().getRealPath(
		"/");
		return appPath;
	}
	/**
	 * 通用的分页查询方法
	 * @param list
	 * @param config
	 * @return
	 */
	public String selAllObjByPage(Page realPage,JsonConfig config){
		JSONArray  jsonObj=null;	
		if(null!=config){
			jsonObj = JSONArray.fromObject(realPage.getList(),config);
		}else{
			jsonObj = JSONArray.fromObject(realPage.getList());
		}
		String jsonRealObj = "{\"total\":"+realPage.getPageCount()+",\"rows\":";
		jsonRealObj+=jsonObj.toString()+"}";
		return jsonRealObj;
	}
}
