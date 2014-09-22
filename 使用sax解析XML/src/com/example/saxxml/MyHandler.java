package com.example.saxxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.sax.StartElementListener;

public class MyHandler extends DefaultHandler {
	
	private HashMap<String, String> map=null;//�洢������������������
	
	private List<HashMap<String, String>> list=null;//�洢���Եý�������
	
	private String currentTag=null;//���ڽ���Ԫ�صı�ǩ
	
	private String currentValue=null;//������ǰԪ�ص�ֵ
	
	private String nodeName =null;//������ǰ�ڵ������
	
	
	public MyHandler(String nodename) {
		// TODO Auto-generated constructor stub
		this.nodeName=nodename;
	}
	
	public List<HashMap<String, String>> getList() {
		return list;
	}
	
	//������ʼ�ĵ�����
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//����ȡ����һ����ʼ��ǩ��ʱ��ᴥ���������
		
		list=new ArrayList<HashMap<String,String>>();
		
		
		super.startDocument();
	}
	
	//������ʼԪ�ش���
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		
		//����ȡ���ĵ���ͷ��ʱ�򣬵����������
		
		if(qName.equals(nodeName)){
			
			map=new HashMap<String, String>();
		}
		
		if(attributes!=null && map!=null){
			for (int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
			
		}
		
		currentTag=qName;
	}
	
	//�������ݴ���
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//����xml�ļ���ȡ��������
		
		if(currentTag!=null&&map!=null){
			currentValue=new String(ch,start,length);
			if(currentValue!=null&&!currentValue.trim().equals("")
					&&currentValue.trim().equals("/n")){
				map.put(currentTag, currentValue);
			}
		}
		//�ѵ�ǰ�ڵ��Ӧ��ֵ�ͱ�ǩ����Ϊ��
		currentTag=null;
		currentValue=null;
	}
	
	//������ɴ���
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//����������ǵ�ʱ�����
		
		if(qName.equals(nodeName)){
			list.add(map);
			map=null;
			
		}
		super.endElement(uri, localName, qName);
	}


	


}
