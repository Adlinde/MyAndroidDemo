package com.oa.action.xlt;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oa.common.BaseAction;
import com.oa.entity.OaDept;
import com.oa.entity.OaDocument;
import com.oa.entity.OaSysSetting;
import com.oa.entity.OaUser;
import com.oa.service.IDocumentService;
import com.oa.util.JsonProcessForDate;
import com.oa.util.JsonProcessForSys;
import com.oa.util.JsonProcessForUser;
import com.oa.util.Page;

import com.opensymphony.xwork2.Action;

/**
 * 文档Action类
 * 
 * @author Administrator
 * 
 */
public class DocumentAction_xlt extends BaseAction {
	Logger log = LogManager.getLogger(DocumentAction_xlt.class);// log4j实体类

	private IDocumentService service;// 文档service
	private int state;//是否是回收站 1.不是回收站 2.是回收站
	private OaDocument document;// 文档对象
	private File doc;//文件
	private String docFileName;//文件名
	private String page;//页数
	private Page realPage = new Page();//分页对象
	private String rows;//每页总数
	private String json;
	private String path;//路径
	private Date beginTime;//开始时间
	private Date endTime;//结束时间

	/**
	 * 显示所有文档的方法
	 * 
	 * @return 返回所有文档集合
	 */

	public String list() {

		if (null != page && !"".equals(page)) {
			realPage.setPageIndex(Integer.valueOf(page));

		}

		if (null != rows && !"".equals(rows)) {
			realPage.setPageSize(Integer.valueOf(rows));
		}

		if (document != null) {

			service.selAllDocsByKeys(realPage, document, beginTime, endTime);

		} else {
			service.findAllByPage("from OaDocument doc where doc.fileStatus="
					+ state + " order by doc.uuid desc", realPage);
			if (path != null && path.length() > 0) {
				try {
					path = URLDecoder.decode(path, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				service.findAllByPage("from OaDocument d where d.path='" + path
						+ "' order by d.uuid desc", realPage);
			}
		}

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "oaDocument", "oaDocuments" });
		config.registerJsonValueProcessor(OaUser.class,
				new JsonProcessForUser());
		config.registerJsonValueProcessor(OaSysSetting.class,
				new JsonProcessForSys());
		config.registerJsonValueProcessor(Date.class, new JsonProcessForDate());
		String json = this.selAllObjByPage(realPage, config);
		super.exitTxt(json);
		System.out.println(json);

		return Action.NONE;
	}

	/**
	 * 查询文档的方法
	 * 
	 * @return
	 */
	public String search() {
		if (null != page && !"".equals(page)) {
			realPage.setPageIndex(Integer.valueOf(page));

		}

		if (null != rows && !"".equals(rows)) {
			realPage.setPageSize(Integer.valueOf(rows));
		}
		List<OaDocument> list = service.selAllDocsByKeys(realPage, document,
				beginTime, endTime);
		JSONArray array = JSONArray.fromObject(list);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "oaDocument", "oaDocuments" });
		config.registerJsonValueProcessor(OaUser.class,
				new JsonProcessForUser());
		config.registerJsonValueProcessor(OaSysSetting.class,
				new JsonProcessForSys());
		config.registerJsonValueProcessor(Date.class, new JsonProcessForDate());
		String json = array.toString();
		super.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * 加载树部门名称列表
	 * 
	 * @return
	 */
	public String loadDepts() {
		List<OaDept> list = service
				.findAll("from OaDept o where o.oaDept.uuid is null");
		String json = mkDeptJson(list);
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * 加载部门名称列表
	 * 
	 * @return
	 */

	public String loadDeptsTree() {
		List<OaDept> list = service.findAll("from OaDept");

		json = "[";

		for (OaDept dept : list) {
			if (dept.getOaDept() != null) {

				json += "{\"id\":\"" + dept.getUuid() + "\",\"name\":\""
						+ dept.getDeptName() + "\",\"pId\":\""
						+ dept.getOaDept().getUuid()
						+ "\",\"link\":\"listDocument.action?state=1&path="
						+ dept.getDeptName() + "\",\"open\":\"true\"},";
			}

		}
		if (json.indexOf(',') > 0) {
			json = json.substring(0, json.length() - 1);

		}
		json += "]";
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * 上传文件的方法
	 * 
	 * @return
	 */
	public String addFile() {

		OaUser user = (OaUser) this.getFromSession("currentUser");
		String appPath = this.applicationpath();
		OaDept dept = service.selObjById("from OaDept dept where dept.uuid=?",
				Integer.valueOf(document.getPath()));
		String storePath = appPath + "sysFiles\\" + dept.getDeptName() + "\\"
				+ user.getName();
		File file = new File(storePath);
		if (!file.exists()) {
			file.mkdirs();
		}

		document.setFileCreattime(new Date());
		document.setIsFile(2);
		document.setFileStatus(1);
		document.setOaUser(user);

		int row = service.save(document);

		if (row > 0) {
			json = "{\"status\":\"2\",\"msg\":\"上传成功\"}";
		} else {
			json = "{\"status\":\"1\",\"msg\":\"上传失败 \"}";
		}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * 添加文件夹的方法
	 * 
	 * @return
	 */
	public String addFold() {

		String appPath = this.applicationpath();
		OaDocument d = service.selObjByName("from OaDocument where dept.filename", document
				.getFilename());
		
		OaDept dept = service.selObjById("from OaDept dept where dept.uuid=?",
				Integer.valueOf(document.getPath()));
		if(d!=null){
			if(d.getPath().equals(document.getPath())){
				json = "{\"status\":\"1\",\"msg\":\"该文件夹已经存在\"}";
				
			}
		}else{
		String storePath = appPath + "sysFiles\\" + dept.getDeptName();
		document.setPath(dept.getDeptName());
		File file = new File(storePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		document.setUrl(storePath);
		document.setFileCreattime(new Date());
		OaUser user = (OaUser) this.getFromSession("currentUser");
		document.setIsFile(1);
		document.setFileStatus(1);
		document.setOaUser(user);
		int row = service.save(document);
		if (row > 0) {

			json = "{\"status\":\"2\",\"msg\":\"listDocument.action?state=1\"}";

		} else {
			json = "{\"status\":\"1\",\"msg\":\"添加失败 \"}";
		}
	}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);
		return Action.NONE;
	}

	/**
	 * 刪除文档的方法
	 * 
	 * @return
	 */
	public String delete() {
		document = service.selObjById("from OaDocument doc where doc.uuid=? ",
				document.getUuid());
		if (document.getFileStatus() == 1) {

			if (document.getIsFile() == 1) {
				Set<OaDocument> docs = document.getOaDocuments();
				if (docs.size() > 0) {
					json = "{\"status\":\"1\",\"msg\":\"文件夹下有文件，先删除文件\"}";
				} else {

					document.setFileStatus(2);
					int row = service.update(document);
					if (row > 0) {
						json = "{\"status\":\"2\",\"msg\":\"刪除文件夹成功\"}";
					} else {
						json = "{\"status\":\"1\",\"msg\":\"刪除文件夹失败\"}";
					}
				}
			} else {

				document.setFileStatus(2);
				int row = service.update(document);
				if (row > 0) {
					json = "{\"status\":\"2\",\"msg\":\"刪除文件夹成功\"}";
				} else {
					json = "{\"status\":\"1\",\"msg\":\"刪除文件夹失败\"}";
				}
			}
		} else {
			if (document.getIsFile() == 1) {
				Set<OaDocument> docs = document.getOaDocuments();
				if (docs.size() > 0) {
					json = "{\"status\":\"1\",\"msg\":\"文件夹下有文件，先删除文件\"}";
				} else {
					int row = service.delete(document);
					if (row > 0) {
						json = "{\"status\":\"2\",\"msg\":\"刪除文件夹成功\"}";
					} else {
						json = "{\"status\":\"1\",\"msg\":\"刪除文件夹失败\"}";
					}
				}
			} else {
				int row = service.delete(document);
				if (row > 0) {
					json = "{\"status\":\"2\",\"msg\":\"刪除文件成功\"}";
				} else {
					json = "{\"status\":\"1\",\"msg\":\"刪除文件失败\"}";
				}
			}
		}
		System.out.println(json);
		log.debug("json:" + json);
		this.exitTxt(json);

		return Action.NONE;
	}

	/**
	 * 修改文档的方法
	 * 
	 * @return
	 */
	public String edit() {
		document = service.selObjById("from OaDocument doc where doc.uuid=? ",
				document.getUuid());
		int row = service.update(document);
		if (row > 0) {
			json = "{\"status\":\"2\",\"msg\":\"文件修改成功\"}";
		} else {
			json = "{\"status\":\"1\",\"msg\":\"文件修改失败\"}";
		}
		log.debug("json:" + json);
		this.exitTxt(json);

	
		return Action.NONE;
	}
	
	/**
	 * 还原文档的方法
	 * @return
	 */
	public String recycle(){
		document = service.selObjById("from OaDocument doc where doc.uuid=? ",
				document.getUuid());
		document.setFileStatus(1);
		int row=service.update(document);
		if (row > 0) {
			json = "{\"status\":\"2\",\"msg\":\"还原文件成功\"}";
		} else {
			json = "{\"status\":\"1\",\"msg\":\"还原文件失败\"}";
		}
		log.debug("json:" + json);
		this.exitTxt(json);

		return Action.NONE;
	}

	
	public OaDocument getDocument() {
		return document;
	}

	public void setDocument(OaDocument document) {
		this.document = document;
	}

	public IDocumentService getService() {
		return service;
	}

	public void setService(IDocumentService service) {
		this.service = service;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
