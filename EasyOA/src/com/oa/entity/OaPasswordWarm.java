package com.oa.entity;



/**������ʾ�����һ�����
 * OaPasswordWarm entity. @author MyEclipse Persistence Tools
 */

public class OaPasswordWarm  implements java.io.Serializable {


    // Fields    

     private Integer uuid;//
     private OaUser oaUser;//
     private String passwordQuestion;//��������
     private String passwordAnswer;//�����


    // Constructors

    /** default constructor */
    public OaPasswordWarm() {
    }

    
    /** full constructor */
    public OaPasswordWarm(OaUser oaUser, String passwordQuestion, String passwordAnswer) {
        this.oaUser = oaUser;
        this.passwordQuestion = passwordQuestion;
        this.passwordAnswer = passwordAnswer;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public OaUser getOaUser() {
        return this.oaUser;
    }
    
    public void setOaUser(OaUser oaUser) {
        this.oaUser = oaUser;
    }

    public String getPasswordQuestion() {
        return this.passwordQuestion;
    }
    
    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordAnswer() {
        return this.passwordAnswer;
    }
    
    public void setPasswordAnswer(String passwordAnswer) {
        this.passwordAnswer = passwordAnswer;
    }
   








}