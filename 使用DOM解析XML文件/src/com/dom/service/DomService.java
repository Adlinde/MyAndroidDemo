package com.dom.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dom.entity.Book;
import com.dom.http.HttpUtils;

public class DomService {

	public DomService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> getBooks(InputStream inputStream) throws Exception{
		List<Book> list=new ArrayList<Book>();
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		Document document=builder.parse(inputStream);
		
		Element element=document.getDocumentElement();//获得稳定的元素节点
		
		NodeList bookNodes=element.getElementsByTagName("book");
		for (int i = 0; i < bookNodes.getLength(); i++) {
			Element bookElement=(Element)bookNodes.item(i);
			Book book=new Book();
			book.setId(Integer.valueOf(bookElement.getAttribute("id")));
			
			NodeList childNodes=bookElement.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
					
					if("name".equals(childNodes.item(j).getNodeName())){
						
						book.setName(childNodes.item(j).getFirstChild().getNodeValue());
					
					}else if("price".equals(childNodes.item(j).getNodeName())){
						
						book.setPrice(Float.parseFloat(childNodes.item(j).getFirstChild().getNodeValue()));
						
					}
				}
			}
			list.add(book);
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		String path="地址";
		
		InputStream inputStream=HttpUtils.getXML(path);
		
		DomService service=new DomService();
		try {
			List<Book> list=service.getBooks(inputStream);
			for (Book book : list) {
				
				System.out.println(book.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
