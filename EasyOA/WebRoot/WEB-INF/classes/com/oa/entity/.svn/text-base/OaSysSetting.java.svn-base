package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**系统设置表
 * OaSysSetting entity. @author MyEclipse Persistence Tools
 */

public class OaSysSetting implements java.io.Serializable {

	// Fields

	private Integer uuid;
	private String type;
	private Integer maxSize;
	private Date dutyOn;
	private Date dutyOff;
	private Set oaDocuments = new HashSet(0);

	// Constructors

	/** default constructor */
	public OaSysSetting() {
	}

	/** full constructor */
	public OaSysSetting(String type, Integer maxSize, Date dutyOn,
			Date dutyOff, Set oaDocuments) {
		this.type = type;
		this.maxSize = maxSize;
		this.dutyOn = dutyOn;
		this.dutyOff = dutyOff;
		this.oaDocuments = oaDocuments;
	}

	// Property accessors

	public Integer getUuid() {
		return this.uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	public Date getDutyOn() {
		return this.dutyOn;
	}

	public void setDutyOn(Date dutyOn) {
		this.dutyOn = dutyOn;
	}

	public Date getDutyOff() {
		return this.dutyOff;
	}

	public void setDutyOff(Date dutyOff) {
		this.dutyOff = dutyOff;
	}

	public Set getOaDocuments() {
		return this.oaDocuments;
	}

	public void setOaDocuments(Set oaDocuments) {
		this.oaDocuments = oaDocuments;
	}

}