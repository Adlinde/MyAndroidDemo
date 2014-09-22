package com.oa.entity;

import java.util.HashSet;
import java.util.Set;

import com.oa.entity.OaDictionary;


/**车辆表
 * OaCar entity. @author MyEclipse Persistence Tools
 */

public class OaCar  implements java.io.Serializable {


    // Fields    

     private Integer number;//编号主键
     private String carnum;//车牌号
     private OaDictionary oaDictionary;//车型
     private String comment;//备注
     private Integer state;//状态
     private Set oaApplyCars = new HashSet(0);


     // Constructors

     /** default constructor */
     public OaCar() {
     }

     
     /** full constructor */
     public OaCar(OaDictionary oaDictionary, String carnum, String comment, Integer state, Set oaApplyCars) {
         this.oaDictionary = oaDictionary;
         this.carnum = carnum;
         this.comment = comment;
         this.state = state;
         this.oaApplyCars = oaApplyCars;
     }

    
     // Property accessors

     public Integer getNumber() {
         return this.number;
     }
     
     public void setNumber(Integer number) {
         this.number = number;
     }

     public OaDictionary getOaDictionary() {
         return this.oaDictionary;
     }
     
     public void setOaDictionary(OaDictionary oaDictionary) {
         this.oaDictionary = oaDictionary;
     }

     public String getCarnum() {
         return this.carnum;
     }
     
     public void setCarnum(String carnum) {
         this.carnum = carnum;
     }

     public String getComment() {
         return this.comment;
     }
     
     public void setComment(String comment) {
         this.comment = comment;
     }

     public Integer getState() {
         return this.state;
     }
     
     public void setState(Integer state) {
         this.state = state;
     }

     public Set getOaApplyCars() {
         return this.oaApplyCars;
     }
     
     public void setOaApplyCars(Set oaApplyCars) {
         this.oaApplyCars = oaApplyCars;
     }
   








}