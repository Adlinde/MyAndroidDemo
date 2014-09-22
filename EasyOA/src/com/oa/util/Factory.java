package com.oa.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Factory {
	 
	/*ҳ����ʾ���ݵ� ����
	 */
	public static int pageSize=10;
	
	public static SimpleDateFormat  sdf  = new SimpleDateFormat();
	
	
	/**
	 * �ļ��ϴ���ַ���ļ������ã�
	 * @param appPath
	 * @param orignFileName
	 * mkFileName()
	 * @return
	 */
	public static String mkFileName(String appPath,String orignFileName)
	{
		String storeDir ="userFiles/"+getDate("yyyy/MM/",new Date());
		File tempFile=new File(appPath+"/"+storeDir);
		//return getDate("yyyyMMddHHssS",new Date());
		if(!tempFile.exists()){
			tempFile.mkdirs();
		}
		return storeDir+UUID.randomUUID().toString()+getFileExt(orignFileName);
	}
	/**
	 * �õ��ļ���׺��
	 * @param fileName
	 * @return
	 */
	public static String getFileExt(String fileName)
	{
		String ext="";
		if(fileName!=null&&fileName.length()>0)
		{
			ext=fileName.substring(fileName.lastIndexOf("."));
		}
		return ext;
	}
	/**
	 * ���ڸ�ʽ����
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String getDate(String pattern,Date date)
	{
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	/**
	 * ���ڸ�ʽת��Ϊ�ַ���
	 * @param pattern
	 * @return
	 */
	public static String dateConvertString(Date date)
	{
		return sdf.format(date);
	}
	/**
	 * ���ڸ�ʽ��
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static Date longDateConvertDate(Date langdate, String format)
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ");
	    Date d =new Date();
	    String dd =sf.format(d);
	    Date ddd;
	  try {
	   ddd = sf.parse(dd);
	   System.out.println("ddd>>>  "+sf.format(ddd));
	  } catch (ParseException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
		return d;
	}
	
	/**
	 * �ַ���ת��Ϊ���ڸ�ʽ
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static Date StringConvertdate(String date)
	{
		Date da=new Date();
		try {
			da=sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  da;
	}
	
}
