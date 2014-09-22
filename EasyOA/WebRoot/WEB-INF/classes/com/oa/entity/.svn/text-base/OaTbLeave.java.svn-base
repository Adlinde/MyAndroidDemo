package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**请假表
 * OaTbLeave entity. @author MyEclipse Persistence Tools
 */

public class OaTbLeave implements java.io.Serializable {

	// Fields

	private Integer uuid;//请假ID
	private OaDictionary oaDictionary;//请假类型
	private OaUser oaUserByNextUserid;//下一个审批人
	private OaUser oaUserByUserid;//请假人
	private Integer department;//部门
	private Date begintime;//开始时间
	private Date endtime;//结束时间
	private Integer leaveDay;//请假天数
	private String leaveReason;//请假事由
	private Set oaApplyResults = new HashSet(0);

	// Constructors

	/** default constructor */
	public OaTbLeave() {
	}

	/** full constructor */
	public OaTbLeave(OaDictionary oaDictionary, OaUser oaUserByNextUserid,
			OaUser oaUserByUserid, Integer department, Date begintime,
			Date endtime, Integer leaveDay, String leaveReason,
			Set oaApplyResults) {
		this.oaDictionary = oaDictionary;
		this.oaUserByNextUserid = oaUserByNextUserid;
		this.oaUserByUserid = oaUserByUserid;
		this.department = department;
		this.begintime = begintime;
		this.endtime = endtime;
		this.leaveDay = leaveDay;
		this.leaveReason = leaveReason;
		this.oaApplyResults = oaApplyResults;
	}

	// Property accessors

	public Integer getUuid() {
		return this.uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public OaDictionary getOaDictionary() {
		return this.oaDictionary;
	}

	public void setOaDictionary(OaDictionary oaDictionary) {
		this.oaDictionary = oaDictionary;
	}

	public OaUser getOaUserByNextUserid() {
		return this.oaUserByNextUserid;
	}

	public void setOaUserByNextUserid(OaUser oaUserByNextUserid) {
		this.oaUserByNextUserid = oaUserByNextUserid;
	}

	public OaUser getOaUserByUserid() {
		return this.oaUserByUserid;
	}

	public void setOaUserByUserid(OaUser oaUserByUserid) {
		this.oaUserByUserid = oaUserByUserid;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
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

	public Integer getLeaveDay() {
		return this.leaveDay;
	}

	public void setLeaveDay(Integer leaveDay) {
		this.leaveDay = leaveDay;
	}

	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Set getOaApplyResults() {
		return this.oaApplyResults;
	}

	public void setOaApplyResults(Set oaApplyResults) {
		this.oaApplyResults = oaApplyResults;
	}

}