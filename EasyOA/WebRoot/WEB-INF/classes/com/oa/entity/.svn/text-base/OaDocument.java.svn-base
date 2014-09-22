package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**文档表
 * OaDocument entity. @author MyEclipse Persistence Tools
 */

public class OaDocument implements java.io.Serializable {

	// Fields

	private Integer uuid;//文档ID
	private OaDocument oaDocument;//文档对象
	private OaUser oaUser;//创建人
	private OaSysSetting oaSysSetting;//系统设置
	private String filename;//文件名
	private Integer fileStatus;//文件状态 1.不是回收站  2.是回收站
	private Date fileCreattime;//创建时间
	private String path;//部门
	private String remark;//备注
	private Integer isFile;//是否是文件  1.不是文件  2.是文件
	private String url;//路径
	private Set oaDocuments = new HashSet(0);

	// Constructors

	/** default constructor */
	public OaDocument() {
	}

	/** full constructor */
	public OaDocument(OaDocument oaDocument, OaUser oaUser,
			OaSysSetting oaSysSetting, String filename, Integer fileStatus,
			Date fileCreattime, String path, String remark, Integer isFile,
			String url, Set oaDocuments) {
		this.oaDocument = oaDocument;
		this.oaUser = oaUser;
		this.oaSysSetting = oaSysSetting;
		this.filename = filename;
		this.fileStatus = fileStatus;
		this.fileCreattime = fileCreattime;
		this.path = path;
		this.remark = remark;
		this.isFile = isFile;
		this.url = url;
		this.oaDocuments = oaDocuments;
	}

	// Property accessors

	public Integer getUuid() {
		return this.uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public OaDocument getOaDocument() {
		return this.oaDocument;
	}

	public void setOaDocument(OaDocument oaDocument) {
		this.oaDocument = oaDocument;
	}

	public OaUser getOaUser() {
		return this.oaUser;
	}

	public void setOaUser(OaUser oaUser) {
		this.oaUser = oaUser;
	}

	public OaSysSetting getOaSysSetting() {
		return this.oaSysSetting;
	}

	public void setOaSysSetting(OaSysSetting oaSysSetting) {
		this.oaSysSetting = oaSysSetting;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getFileStatus() {
		return this.fileStatus;
	}

	public void setFileStatus(Integer fileStatus) {
		this.fileStatus = fileStatus;
	}

	public Date getFileCreattime() {
		return this.fileCreattime;
	}

	public void setFileCreattime(Date fileCreattime) {
		this.fileCreattime = fileCreattime;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsFile() {
		return this.isFile;
	}

	public void setIsFile(Integer isFile) {
		this.isFile = isFile;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getOaDocuments() {
		return this.oaDocuments;
	}

	public void setOaDocuments(Set oaDocuments) {
		this.oaDocuments = oaDocuments;
	}

}