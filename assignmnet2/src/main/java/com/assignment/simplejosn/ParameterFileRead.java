package com.assignment.simplejosn;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParameterFileRead {
	
	public static Map< String , String  > fileDescripter = new HashMap<>();

	public static void enviromentLoad () {
		
		
		try   
		{  
		//creating a constructor of file class and parsing an XML file  
		File file = new File("C:\\Users\\DELL\\Desktop\\sit\\Parameter.XML");  
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("Environemnt"); 
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
		Node node = nodeList.item(itr);  
		System.out.println("\nNode Name :" + node.getNodeName());  
		if (node.getNodeType() == Node.ELEMENT_NODE)   
		{  
		Element eElement = (Element) node;  
		fileDescripter.put(eElement.getElementsByTagName("Env").item(0).getTextContent(),  
		eElement.getElementsByTagName("Folder").item(0).getTextContent());   
		}  
		}  
		}
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  

	}

}
