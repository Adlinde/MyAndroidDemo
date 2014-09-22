package com.pull.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.pull.entity.Person;

/** ��Ҫ��ʹ��PULL����xml
 * @author ������ */

public class PullXMLTools {

	public PullXMLTools() {
		// TODO Auto-generated constructor stub
	}

	/** @param inputStream�ӷ�������ȡxml�ļ�����������ʽ���أ�
	 * @param encode�����ʽ
	 * @return */
	public static List<Person> parserXML(InputStream inputStream, String encode) {
		List<Person> list = null;//װ�ؽ���ÿһ��person�ڵ������
		
		Person person=null;

		//����һ��xml�����Ĺ���

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

			//���xml�����������
			XmlPullParser parser = factory.newPullParser();

			parser.setInput(inputStream, encode);
			//����¼�������
			int eventType = parser.getEventType();

			while (eventType != XmlPullParser.END_DOCUMENT) {

				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					list=new ArrayList<Person>();
					break;
				case XmlPullParser.START_TAG:
					if("person".equals(parser.getName())){
						person=new Person();
						//ȥ������ֵ
						int id=Integer.valueOf(parser.getAttributeValue(0));
						person.setId(id);
					}else if("name".equals(parser.getName())){
							String name=parser.nextText();//��ȡ�ýڵ������
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
