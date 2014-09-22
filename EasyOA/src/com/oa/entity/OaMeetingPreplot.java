package com.oa.entity;

import java.util.Date;

import com.oa.entity.OaDictionary;
import com.oa.entity.OaMeeting;
import com.oa.entity.OaUser;


/**������Ԥ��
 * OaMeetingPreplot entity. @author MyEclipse Persistence Tools
 */

public class OaMeetingPreplot  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private OaMeeting oaMeeting;//������id
     private OaUser oaUserByPreplotUserid;//Ԥ����
     private OaDictionary oaDictionary;//��������
     private OaUser oaUserByRecorder;//��¼��
     private Date begintime;//���鿪ʼʱ��
     private Date endtime;//�������ʱ��
     private Date preplotTime;//Ԥ��ʱ��
     


     // Constructors

     /** default constructor */
     public OaMeetingPreplot() {
     }

     
     /** full constructor */
     public OaMeetingPreplot(OaMeeting oaMeeting, OaUser oaUserByPreplotUserid, OaDictionary oaDictionary, OaUser oaUserByRecorder, Date begintime, Date endtime, Date preplotTime) {
         this.oaMeeting = oaMeeting;
         this.oaUserByPreplotUserid = oaUserByPreplotUserid;
         this.oaDictionary = oaDictionary;
         this.oaUserByRecorder = oaUserByRecorder;
         this.begintime = begintime;
         this.endtime = endtime;
         this.preplotTime = preplotTime;
     }

    
     // Property accessors

     public Integer getUuid() {
         return this.uuid;
     }
     
     public void setUuid(Integer uuid) {
         this.uuid = uuid;
     }

     public OaMeeting getOaMeeting() {
         return this.oaMeeting;
     }
     
     public void setOaMeeting(OaMeeting oaMeeting) {
         this.oaMeeting = oaMeeting;
     }

     public OaUser getOaUserByPreplotUserid() {
         return this.oaUserByPreplotUserid;
     }
     
     public void setOaUserByPreplotUserid(OaUser oaUserByPreplotUserid) {
         this.oaUserByPreplotUserid = oaUserByPreplotUserid;
     }

     public OaDictionary getOaDictionary() {
         return this.oaDictionary;
     }
     
     public void setOaDictionary(OaDictionary oaDictionary) {
         this.oaDictionary = oaDictionary;
     }

     public OaUser getOaUserByRecorder() {
         return this.oaUserByRecorder;
     }
     
     public void setOaUserByRecorder(OaUser oaUserByRecorder) {
         this.oaUserByRecorder = oaUserByRecorder;
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

     public Date getPreplotTime() {
         return this.preplotTime;
     }
     
     public void setPreplotTime(Date preplotTime) {
         this.preplotTime = preplotTime;
     }
   








}