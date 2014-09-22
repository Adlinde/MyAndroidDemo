package com.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**部门表
 * OaDept entity. @author MyEclipse Persistence Tools
 */

public class OaDept  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private OaDept oaDept;//父部门
     private OaUser oaUser;//负责人
     private String deptName;//部门名称
     private String phone;//联系电话
     private String mobilePhone;//移动电话
     private String fax;//传真
     private Integer sort;//排序
     private Set oaUsers = new HashSet(0);
     private Set oaDepts = new HashSet(0);


    // Constructors

    /** default constructor */
    public OaDept() {
    }

    
    /** full constructor */
    public OaDept(OaDept oaDept, OaUser oaUser, String deptName, String phone, String mobilePhone, String fax, Integer sort, Set oaUsers, Set oaDepts) {
        this.oaDept = oaDept;
        this.oaUser = oaUser;
        this.deptName = deptName;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.sort = sort;
        this.oaUsers = oaUsers;
        this.oaDepts = oaDepts;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public OaDept getOaDept() {
        return this.oaDept;
    }
    
    public void setOaDept(OaDept oaDept) {
        this.oaDept = oaDept;
    }

    public OaUser getOaUser() {
        return this.oaUser;
    }
    
    public void setOaUser(OaUser oaUser) {
        this.oaUser = oaUser;
    }

    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getSort() {
        return this.sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Set getOaUsers() {
        return this.oaUsers;
    }
    
    public void setOaUsers(Set oaUsers) {
        this.oaUsers = oaUsers;
    }

    public Set getOaDepts() {
        return this.oaDepts;
    }
    
    public void setOaDepts(Set oaDepts) {
        this.oaDepts = oaDepts;
    }
   








}