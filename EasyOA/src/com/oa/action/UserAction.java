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
 * �û�action��
 * @author Administrator
 *
 */
public class UserAction extends BaseAction{
	Logger  log  = LogManager.getLogger(UserAction.class);//log4jʵ����
	private OaUser user;//�û�ʵ��
	private String imageCode;//��֤��
	private IUserService userService;//�û�����ʵ��
	private String json;//json�ַ���
	private String oldPwd;//������
	private String newPwd;//������
	private Page realPage;//ҳ�����
	private String page;//ҳ��
	private String rows;//ÿҳ��ʾ��
	private File pic;//�ϴ��ļ�
	private String picFileName;	//�ϴ��ļ�����
	private Coord coord;//��ͼ����
	/**
	 * �û�����ʵ�ַ���
	 * @return Action.NONE
	 */
	public String login(){
		//�ж���֤���Ƿ�Ϊ��
		if(null!=imageCode){
			//��ô���session�����֤��
			String realImageCode=(String) super.getFromSession("imageCode");
			//�ж���֤���Ƿ���ͬ
			if(imageCode.equalsIgnoreCase(realImageCode)){
				user.setPassword(MD5Test.GetMD5Code(user.getPassword()));
				user=userService.getRealOaUser(user);
				 //user���ǿձ�ʾ����ɹ�
				if(null!=user){
					user.getOaDept().getDeptName();
					this.putInSession("currentUser", user);
					json ="{\"status\":\"2\",\"msg\":\"centeruser.action\"}";
				}else{
					json ="{\"status\":\"1\",\"msg\":\"�û������������\"}";
				}
			}else{
				json ="{\"status\":\"1\",\"msg\":\"��֤�����\"}";
			}
		}else{
			json ="{\"status\":\"1\",\"msg\":\"��������֤��\"}";
		}
		//��ҳ�����json��װ�Ķ���
		this.exitTxt(json);
		return Action.NONE;
	}
	
	/**
	 * �û�������֤ȫ��ͨ��֮����õ�action
	 * @return ���ص���������ҳ��ַ���
	 */
	public String center(){
		return "center";
	}
	
	/**
	 * ����ְλ�����б�
	 * @return
	 */
	public String loadRoles(){
		  //������е�ְλ����
		  List<OaRole>  roles = userService.findAll("from OaRole ");	    
		  JsonConfig    config  = new JsonConfig();
		  //ȥ�����е�ְλ�������set�ļ�������
		  config.setExcludes(new String[]{"oaUsers","oaRoleAuths"});
		  JSONArray  arrays = JSONArray.fromObject(roles,config);
		  String json  = arrays.toString();
		  log.debug("json:"+json);
		  this.exitTxt(json);
		  return Action.NONE;
	}
	
	/**
	 * ���ز��������б�
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
	 * ͼƬ�ϴ�
	 * @return
	 */
	public  String upload(){
		String storePath = FileUtil.getNewFileName(this.applicationpath(), picFileName, ((OaUser)(this.getFromSession("currentUser"))).getUuid());	
		ImageUtil.scaleImage(null, pic.getAbsolutePath(), this.applicationpath()+"/"+storePath, 300);
		this.exitTxt("{\"status\":\"1\",\"path\":\""+storePath+"\"}");
		return Action.NONE;
	}  
	
	/**
	 * ���һ���û�
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
	 * �����ȡ������ͼƬ
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
	 * �˳�ϵͳ�ķ���
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
	 * �޸�����ķ���
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
				json="{\"status\":\"1\",\"msg\":\"�޸�ʧ��\"}";
			}
		}else{

			json="{\"status\":\"1\",\"msg\":\"ԭ�����������\"}";

		}
		super.exitTxt(json);
		return Action.NONE;
	}

   /**
	 * ��ҳ����û���Ϣ
	 * @return ��ҳ�û���Ϣ
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
	 * ������е��û�
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
