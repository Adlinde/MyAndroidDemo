package com.oa.action.zyq;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.oa.common.BaseAction;
import com.oa.entity.OaDept;
import com.oa.entity.OaUser;
import com.oa.service.IDepartmentService;
import com.oa.util.JsonProcessForDept;
import com.oa.util.JsonProcessForUserUuid;
import com.opensymphony.xwork2.Action;

/**
 * 部门action类
 * 
 * @author zyq
 * 
 */
public class DeptAction_zyq extends BaseAction {
	private IDepartmentService deptService;// 部门业务实体类
	private String json;// json字符串
	private OaDept dept;//部门传递实体

	/***
	 * 查出所有的部门信息
	 * 
	 * @return
	 */
	public String loadTree() {
		List<OaDept> list = deptService.findAll("from OaDept");
		json = "[";
		for (OaDept dept : list) {
			if (dept.getOaDept() != null) {
				json += "{\"id\":\"" + dept.getUuid() + "\",\"name\":\""
						+ dept.getDeptName() + "\",\"pId\":\""
						+ dept.getOaDept().getUuid()
						+ "\",\"link\":\"selbyiddept.action?dept.uuid="
						+ dept.getUuid() + "\",\"open\":\"true\"},";
			}
		}
		if (json.indexOf(',') > 0) {
			json = json.substring(0, json.length() - 1);

		}
		json += "]";
		System.out.println(json);
		this.exitTxt(json);
		return Action.NONE;
	}
	/**
	 * 根据ID查询部门对象
	 * @return
	 */
	public String selbyid() {
		OaDept realOaDept=deptService.selObjById("from OaDept d where d.uuid=?", dept.getUuid());
		JsonConfig    config  = new JsonConfig();
		  //去掉所有的职位名称里的set的集合类型
		config.setExcludes(new String[]{"oaUsers","oaDepts"});
		config.registerJsonValueProcessor(OaUser.class,new JsonProcessForUserUuid());
		config.registerJsonValueProcessor(OaDept.class,new JsonProcessForDept());
		JSONObject jsonObj=JSONObject.fromObject(realOaDept,config);
		System.out.println(jsonObj.toString());
		this.exitTxt(jsonObj.toString());
		return Action.NONE;
	}
	
	/**
	 * 添加一条部门信息
	 * @return
	 */
	public String add(){
		int row=deptService.save(dept);
		if(row>0){
			json="{\"status\":\"2\",\"msg\":\"部门信息添加成功\"}";
		}
		else{
			json="{\"status\":\"1\",\"msg\":\"部门信息添加失败\"}";
		}
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * 更新一条部门信息
	 * @return
	 */
	public String update(){
		int row=deptService.update(dept);
		if(row>0){
			json="{\"status\":\"2\",\"msg\":\"部门信息修改成功\"}";
		}
		else{
			json="{\"status\":\"1\",\"msg\":\"部门信息修改失败\"}";
		}
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * 删除一条部门信息
	 * @return
	 */
	public String del(){
		int row=deptService.delete(dept);
		if(row>0){
			json="{\"status\":\"2\",\"msg\":\"删除成功\"}";
		}
		else{
			json="{\"status\":\"1\",\"msg\":\"删除失败\"}";
		}
		this.exitTxt(json);
		return Action.NONE;
	}
	
	public IDepartmentService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDepartmentService deptService) {
		this.deptService = deptService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public OaDept getDept() {
		return dept;
	}

	public void setDept(OaDept dept) {
		this.dept = dept;
	}
	
}
