package com.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**车辆申请
 * OaApplyCar entity. @author MyEclipse Persistence Tools
 */

public class OaApplyCar  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private OaCar oaCar;//车辆编号
     private OaUser oaUserByNextUserid;//下一步审批人
     private OaUser oaUserByUsedcarUuid;//用车人
     private String partypeople;//随行人员
     private String driver;//司机
     private Integer userdcardDepartment;//用车部门
     private Date begintime;//用车开始时间
     private Date endtime;//用车结束时间
     private String adress;//目的地
     private String mileage;//申请里程
     private String reason;//用车事由
     private Set oaApplyResults = new HashSet(0);


    // Constructors

    /** default constructor */
    public OaApplyCar() {
    }

    
    /** full constructor */
    public OaApplyCar(OaCar oaCar, OaUser oaUserByNextUserid, OaUser oaUserByUsedcarUuid, String partypeople, String driver, Integer userdcardDepartment, Date begintime, Date endtime, String adress, String mileage, String reason, Set oaApplyResults) {
        this.oaCar = oaCar;
        this.oaUserByNextUserid = oaUserByNextUserid;
        this.oaUserByUsedcarUuid = oaUserByUsedcarUuid;
        this.partypeople = partypeople;
        this.driver = driver;
        this.userdcardDepartment = userdcardDepartment;
        this.begintime = begintime;
        this.endtime = endtime;
        this.adress = adress;
        this.mileage = mileage;
        this.reason = reason;
        this.oaApplyResults = oaApplyResults;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public OaCar getOaCar() {
        return this.oaCar;
    }
    
    public void setOaCar(OaCar oaCar) {
        this.oaCar = oaCar;
    }

    public OaUser getOaUserByNextUserid() {
        return this.oaUserByNextUserid;
    }
    
    public void setOaUserByNextUserid(OaUser oaUserByNextUserid) {
        this.oaUserByNextUserid = oaUserByNextUserid;
    }

    public OaUser getOaUserByUsedcarUuid() {
        return this.oaUserByUsedcarUuid;
    }
    
    public void setOaUserByUsedcarUuid(OaUser oaUserByUsedcarUuid) {
        this.oaUserByUsedcarUuid = oaUserByUsedcarUuid;
    }

    public String getPartypeople() {
        return this.partypeople;
    }
    
    public void setPartypeople(String partypeople) {
        this.partypeople = partypeople;
    }

    public String getDriver() {
        return this.driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getUserdcardDepartment() {
        return this.userdcardDepartment;
    }
    
    public void setUserdcardDepartment(Integer userdcardDepartment) {
        this.userdcardDepartment = userdcardDepartment;
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

    public String getMileage() {
        return this.mileage;
    }
    
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Set getOaApplyResults() {
        return this.oaApplyResults;
    }
    
    public void setOaApplyResults(Set oaApplyResults) {
        this.oaApplyResults = oaApplyResults;
    }
   








}