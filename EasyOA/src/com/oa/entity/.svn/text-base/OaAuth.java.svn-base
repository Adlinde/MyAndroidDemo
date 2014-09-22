package com.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**权限表
 * OaAuth entity. @author MyEclipse Persistence Tools
 */

public class OaAuth  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private OaAuth oaAuth;//所属父权限
     private String authName;//权限名称
     private String authPath;//权限路径
     private Integer isMenu;//是否是菜单
     private Set oaAuths = new HashSet(0);
     private Set oaRoleAuths = new HashSet(0);


    // Constructors

    /** default constructor */
    public OaAuth() {
    }

    
    /** full constructor */
    public OaAuth(OaAuth oaAuth, String authName, String authPath, Integer isMenu, Set oaAuths, Set oaRoleAuths) {
        this.oaAuth = oaAuth;
        this.authName = authName;
        this.authPath = authPath;
        this.isMenu = isMenu;
        this.oaAuths = oaAuths;
        this.oaRoleAuths = oaRoleAuths;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public OaAuth getOaAuth() {
        return this.oaAuth;
    }
    
    public void setOaAuth(OaAuth oaAuth) {
        this.oaAuth = oaAuth;
    }

    public String getAuthName() {
        return this.authName;
    }
    
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPath() {
        return this.authPath;
    }
    
    public void setAuthPath(String authPath) {
        this.authPath = authPath;
    }

    public Integer getIsMenu() {
        return this.isMenu;
    }
    
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Set getOaAuths() {
        return this.oaAuths;
    }
    
    public void setOaAuths(Set oaAuths) {
        this.oaAuths = oaAuths;
    }

    public Set getOaRoleAuths() {
        return this.oaRoleAuths;
    }
    
    public void setOaRoleAuths(Set oaRoleAuths) {
        this.oaRoleAuths = oaRoleAuths;
    }
   








}