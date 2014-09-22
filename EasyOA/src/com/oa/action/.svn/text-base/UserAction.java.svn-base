package com.oa.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaDept;
import com.oa.entity.OaRole;
import com.oa.entity.OaUser;
import com.oa.service.IDepartmentService;
import com.oa.service.IUserService;
import com.oa.util.Coord;
import com.oa.util.FileUtil;
import com.oa.util.ImageUtil;
import com.oa.util.JsonProcessForDept;
import com.oa.util.JsonProcessForRole;
import com.oa.util.MD5Test;
import com.oa.util.Page;
import com.opensymphony.xwork2.Action;
/**
 * 用户action类
 * @author Administrator
 *
 */
public class UserAction extends BaseAction{
	Logger  log  = LogManager.getLogger(UserAction.class);//log4j实体类
	private OaUser user;//用户实体
	private String imageCode;//验证码
	private IUserService userService;//用户服务实体
	private String json;//json字符串
	private String oldPwd;//旧密码
	private String newPwd;//新密码
	private Page realPage;//页码对象
	private String page;//页数
	private String rows;//每页显示数
	private File pic;//上传文件
	private String picFileName;	//上传文件名字
	private Coord coord;//截图坐标
	/**
	 * 用户登入实现方法
	 * @return Action.NONE
	 */
	public String login(){
		//判断验证码是否为空
		if(null!=imageCode){
			//获得存在session里的验证码
			String realImageCode=(String) super.getFromSession("imageCode");
			//判断验证码是否相同
			if(imageCode.equalsIgnoreCase(realImageCode)){
				user.setPassword(MD5Test.GetMD5Code(user.getPassword()));
				user=userService.getRealOaUser(user);
				 //user不是空表示登入成功
				if(null!=user){
					user.getOaDept().getDeptName();
					this.putInSession("currentUser", user);
					json ="{\"status\":\"2\",\"msg\":\"centeruser.action\"}";
				}else{
					json ="{\"status\":\"1\",\"msg\":\"用户名或密码错误\"}";
				}
			}else{
				json ="{\"status\":\"1\",\"msg\":\"验证码错误\"}";
			}
		}else{
			json ="{\"status\":\"1\",\"msg\":\"请输入验证码\"}";
		}
		//向页面输出json组装的对象
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * 用户登入验证全部通过之后调用的action
	 * @return 返回到登入后的首页地址结果
	 */
	public String center(){
		return "center";
	}
	
	/**
	 * 加载职位名称列表
	 * @return
	 */
	public String loadRoles(){
		  //查出所有的职位名称
		  List<OaRole>  roles = userService.findAll("from OaRole ");	    
		  JsonConfig    config  = new JsonConfig();
		  //去掉所有的职位名称里的set的集合类型
		  config.setExcludes(new String[]{"oaUsers","oaRoleAuths"});
		  JSONArray  arrays = JSONArray.fromObject(roles,config);
		  String json  = arrays.toString();
		  log.debug("json:"+json);
		  this.exitTxt(json);
		  return Action.NONE;
	}
	
	/**
	 * 加载部门名称列表
	 * @return
	 */
	public String loadDepts(){
		List<OaDept> list=userService.findAll("from OaDept o where o.oaDept.uuid is null");
		String json=mkDeptJson(list);
		log.debug("json:"+json);
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * 图片上传
	 * @return
	 */
	public  String upload(){
		String storePath = FileUtil.getNewFileName(this.applicationpath(), picFileName, ((OaUser)(this.getFromSession("currentUser"))).getUuid());	
		ImageUtil.scaleImage(null, pic.getAbsolutePath(), this.applicationpath()+"/"+storePath, 300);
		this.exitTxt("{\"status\":\"1\",\"path\":\""+storePath+"\"}");
		return Action.NONE;
	}  
	
	/**
	 * 添加一个用户
	 * @return
	 */
	public String save(){
		user.setPassword(MD5Test.GetMD5Code(user.getPassword()));
		int result  = userService.save(user);
		if(result>0){
			this.exitTxt("{\"status\":\"1\"}");
		}else{
			this.exitTxt("{\"status\":\"2\"}");
		}
		return Action.NONE;
	}
	
	/**
	 * 保存截取下来的图片
	 * @return
	 */
	public String saveCoord(){
		String storePath = FileUtil.getNewFileName(this.applicationpath(), user.getUserPic(), ((OaUser)(this.getFromSession("currentUser"))).getUuid());	
		ImageUtil.scaleImage(coord, this.applicationpath()+"/"+user.getUserPic(),
				this.applicationpath()+"/"+storePath, 0);	
		this.exitTxt("{\"status\":\"1\",\"path\":\""+storePath+"\"}");		
		return Action.NONE;
	}
	/**
	 * 退出系统的方法
	 * @return
	 */
	public String exit(){	
		OaUser user= (OaUser) super.getFromSession("currentUser");
		if(user!=null){
			super.putInSession("currentUser", null);
		}
		return "login";
	}
	
	/**
	 * 修改密码的方法
	 * @return
	 */
	public String editPwd(){		
		oldPwd=MD5Test.GetMD5Code(oldPwd);
		OaUser user= (OaUser) super.getFromSession("currentUser");
		if(oldPwd.equals(user.getPassword())){
			user.setPassword(MD5Test.GetMD5Code(newPwd));
			int row=userService.update(user);
			if(row>0){
				json="{\"status\":\"2\",\"msg\":\"exituser.action\"}";
			}
			else{
				json="{\"status\":\"1\",\"msg\":\"修改失败\"}";
			}
		}else{

			json="{\"status\":\"1\",\"msg\":\"原密码输入错误\"}";

		}
		super.exitTxt(json);
		return Action.NONE;
	}

   /**
	 * 分页查出用户信息
	 * @return 分页用户信息
	 */
	public String selall(){
		if(null!=page && !"".equals(page)){
			realPage.setPageIndex(Integer.valueOf(page));
		}
		if(null!=rows && !"".equals(rows)){
			realPage.setPageSize(Integer.valueOf(rows));
		}
		userService.findAllByPage("from OaUser", realPage);
		JsonConfig   config  = new JsonConfig();
		config.registerJsonValueProcessor(OaRole.class, new JsonProcessForRole());
	    config.registerJsonValueProcessor(OaDept.class, new JsonProcessForDept());
		String json=this.selAllObjByPage(realPage, config);
		super.exitTxt(json);
		return Action.NONE;
	}
	/**
	 * 查出所有的用户
	 * @return
	 */
	public String selOneAll(){
		List list=userService.findAll("from OaUser");
		JsonConfig   config  = new JsonConfig();
		config.registerJsonValueProcessor(OaRole.class, new JsonProcessForRole());
		config.registerJsonValueProcessor(OaDept.class, new JsonProcessForDept());
		JSONArray jsonObj=JSONArray.fromObject(list,config);
		System.out.println(jsonObj.toString());
		super.exitTxt(jsonObj.toString());
		return Action.NONE;
		
	}
	
	
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}


	public OaUser getUser() {
		return user;
	}

	public void setUser(OaUser user) {
		this.user = user;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Page getRealPage() {
		return realPage;
	}

	public void setRealPage(Page realPage) {
		this.realPage = realPage;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
		
}
