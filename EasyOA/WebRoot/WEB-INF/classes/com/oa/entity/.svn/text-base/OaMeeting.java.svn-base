package com.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**会议室表
 * OaMeeting entity. @author MyEclipse Persistence Tools
 */

public class OaMeeting  implements java.io.Serializable {


    // Fields    

     private Integer uuid;
     private String meetingName;//会议室名称
     private String meetingDesc;//会议室描述
     private Integer meetingState;//会议室状态
     private Set oaMeetingPreplots = new HashSet(0);


    // Constructors

    /** default constructor */
    public OaMeeting() {
    }

    
    /** full constructor */
    public OaMeeting(String meetingName, String meetingDesc, Integer meetingState, Set oaMeetingPreplots) {
        this.meetingName = meetingName;
        this.meetingDesc = meetingDesc;
        this.meetingState = meetingState;
        this.oaMeetingPreplots = oaMeetingPreplots;
    }

   
    // Property accessors

    public Integer getUuid() {
        return this.uuid;
    }
    
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getMeetingName() {
        return this.meetingName;
    }
    
    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingDesc() {
        return this.meetingDesc;
    }
    
    public void setMeetingDesc(String meetingDesc) {
        this.meetingDesc = meetingDesc;
    }

    public Integer getMeetingState() {
        return this.meetingState;
    }
    
    public void setMeetingState(Integer meetingState) {
        this.meetingState = meetingState;
    }

    public Set getOaMeetingPreplots() {
        return this.oaMeetingPreplots;
    }
    
    public void setOaMeetingPreplots(Set oaMeetingPreplots) {
        this.oaMeetingPreplots = oaMeetingPreplots;
    }
   








}