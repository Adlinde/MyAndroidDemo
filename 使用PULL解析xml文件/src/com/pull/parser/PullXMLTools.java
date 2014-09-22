package com.pull.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.pull.entity.Person;

/** 主要是使用PULL解析xml
 * @author 孙世东 */

public class PullXMLTools {

	public PullXMLTools() {
		// TODO Auto-generated constructor stub
	}

	/** @param inputStream从服务器获取xml文件，以流的形式返回，
	 * @param encode编码格式
	 * @return */
	public static List<Person> parserXML(InputStream inputStream, String encode) {
		List<Person> list = null;//装载解析每一个person节点的内容
		
		Person person=null;

		//创建一个xml解析的工厂

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

			//获得xml继续类的引用
			XmlPullParser parser = factory.newPullParser();

			parser.setInput(inputStream, encode);
			//获得事件的类型
			int eventType = parser.getEventType();

			while (eventType != XmlPullParser.END_DOCUMENT) {

				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					list=new ArrayList<Person>();
					break;
				case XmlPullParser.START_TAG:
					if("person".equals(parser.getName())){
						person=new Person();
						//去除属性值
						int id=Integer.valueOf(parser.getAttributeValue(0));
						person.setId(id);
					}else if("name".equals(parser.getName())){
							String name=parser.nextText();//获取该节点的内容
							person.setName(name);
						
					}else if("age".equals(parser.getName())){
							int age=Integer.valueOf(parser.nextText());
							person.setAge(age);
					}
					break;
				
				case XmlPullParser.END_TAG:
					if("person".equals(parser.getName())){
						list.add(person);
						person=null;	
					}
					break;
				}
				eventType=parser.next();
				

			}

		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
