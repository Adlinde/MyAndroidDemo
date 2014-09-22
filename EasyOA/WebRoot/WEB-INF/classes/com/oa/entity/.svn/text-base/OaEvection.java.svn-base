package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**出差实体类
 * OaEvection entity. @author MyEclipse Persistence Tools
 */

public class OaEvection implements java.io.Serializable {

	// Fields

	private Integer uuid;//出差ID
	private OaUser oaUserByNextUserid;//下一个审批人
	private OaDictionary oaDictionary;//出差工具
	private OaUser oaUserByUserid;//出差人
	private Integer departmentid;//部门
	private Date begintime;//开始时间
	private Date endtime;//结束时间
	private String adress;//地址
	private String evectionResion;//出差事由
	private String evectionWork;//出差任务
	private Float money;//出差费用
	private Set oaApplyResults = new HashSet(0);

	// Constructors

	/** default constructor */
	public OaEvection() {
	}

	/** full constructor */
	public OaEvection(OaUser oaUserByNextUserid, OaDictionary oaDictionary,
			OaUser oaUserByUserid, Integer departmentid, Date begintime,
			Date endtime, String adress, String evectionResion,
			String evectionWork, Float money, Set oaApplyResults) {
		this.oaUserByNextUserid = oaUserByNextUserid;
		this.oaDictionary = oaDictionary;
		this.oaUserByUserid = oaUserByUserid;
		this.departmentid = departmentid;
		this.begintime = begintime;
		this.endtime = endtime;
		this.adress = adress;
		this.evectionResion = evectionResion;
		this.evectionWork = evectionWork;
		this.money = money;
		this.oaApplyResults = oaApplyResults;
	}

	// Property accessors

	public Integer getUuid() {
		return this.uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public OaUser getOaUserByNextUserid() {
		return this.oaUserByNextUserid;
	}

	public void setOaUserByNextUserid(OaUser oaUserByNextUserid) {
		this.oaUserByNextUserid = oaUserByNextUserid;
	}

	public OaDictionary getOaDictionary() {
		return this.oaDictionary;
	}

	public void setOaDictionary(OaDictionary oaDictionary) {
		this.oaDictionary = oaDictionary;
	}

	public OaUser getOaUserByUserid() {
		return this.oaUserByUserid;
	}

	public void setOaUserByUserid(OaUser oaUserByUserid) {
		this.oaUserByUserid = oaUserByUserid;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEvectionResion() {
		return this.evectionResion;
	}

	public void setEvectionResion(String evectionResion) {
		this.evectionResion = evectionResion;
	}

	public String getEvectionWork() {
		return this.evectionWork;
	}

	public void setEvectionWork(String evectionWork) {
		this.evectionWork = evectionWork;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Set getOaApplyResults() {
		return this.oaApplyResults;
	}

	public void setOaApplyResults(Set oaApplyResults) {
		this.oaApplyResults = oaApplyResults;
	}

}