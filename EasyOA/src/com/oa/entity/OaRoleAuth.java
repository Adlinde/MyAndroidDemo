package com.oa.entity;



/**
 * OaRoleAuth entity. @author MyEclipse Persistence Tools
 */

public class OaRoleAuth  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private OaRole oaRole;//��ɫȨ��
     private OaAuth oaAuth;//Ȩ��


    // Constructors

    /** default constructor */
    public OaRoleAuth() {
    }

    
    /** full constructor */
    public OaRoleAuth(OaRole oaRole, OaAuth oaAuth) {
        this.oaRole = oaRole;
        this.oaAuth = oaAuth;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public OaRole getOaRole() {
        return this.oaRole;
    }
    
    public void setOaRole(OaRole oaRole) {
        this.oaRole = oaRole;
    }

    public OaAuth getOaAuth() {
        return this.oaAuth;
    }
    
    public void setOaAuth(OaAuth oaAuth) {
        this.oaAuth = oaAuth;
    }
   








}