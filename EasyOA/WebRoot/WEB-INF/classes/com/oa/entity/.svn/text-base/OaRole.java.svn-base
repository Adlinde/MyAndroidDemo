package com.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**角色表
 * OaRole entity. @author MyEclipse Persistence Tools
 */

public class OaRole  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private String roleName;//角色名称
     private Set oaUsers = new HashSet(0);
     private Set oaRoleAuths = new HashSet(0);


    // Constructors

    /** default constructor */
    public OaRole() {
    }

    
    /** full constructor */
    public OaRole(String roleName, Set oaUsers, Set oaRoleAuths) {
        this.roleName = roleName;
        this.oaUsers = oaUsers;
        this.oaRoleAuths = oaRoleAuths;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set getOaUsers() {
        return this.oaUsers;
    }
    
    public void setOaUsers(Set oaUsers) {
        this.oaUsers = oaUsers;
    }

    public Set getOaRoleAuths() {
        return this.oaRoleAuths;
    }
    
    public void setOaRoleAuths(Set oaRoleAuths) {
        this.oaRoleAuths = oaRoleAuths;
    }
   








}