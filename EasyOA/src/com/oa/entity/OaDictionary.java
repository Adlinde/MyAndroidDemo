package com.oa.entity;



/**�ֵ��
 * OaDictionary entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class OaDictionary  implements java.io.Serializable {


    // Fields    

     private Integer dictionaryUuid;//
     private String dictionnaryValue;//ֵ
     private Integer dictionaryType;//�ֵ����1���2����3ҵ����������4��־����5ͨ������

    // Constructors

    /** default constructor */
    public OaDictionary() {
    }

    
    /** full constructor */
    public OaDictionary(String dictionnaryValue, Integer dictionaryType) {
        this.dictionnaryValue = dictionnaryValue;
        this.dictionaryType = dictionaryType;
    }

   
    // Property accessors

    public Integer getDictionaryUuid() {
        return this.dictionaryUuid;
    }
    
    public void setDictionaryUuid(Integer dictionaryUuid) {
        this.dictionaryUuid = dictionaryUuid;
    }

    public String getDictionnaryValue() {
        return this.dictionnaryValue;
    }
    
    public void setDictionnaryValue(String dictionnaryValue) {
        this.dictionnaryValue = dictionnaryValue;
    }

    public Integer getDictionaryType() {
        return this.dictionaryType;
    }
    
    public void setDictionaryType(Integer dictionaryType) {
        this.dictionaryType = dictionaryType;
    }
}