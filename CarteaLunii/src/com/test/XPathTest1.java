package com.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class XPathTest1 {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true); // never forget this!
	        DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				 Document doc = builder.parse("search.xml");
				 XPathFactory xpathfactory = XPathFactory.newInstance();
			        XPath xpath = xpathfactory.newXPath();
			        XPathExpression expr = xpath.compile("//work");
			    	
		        Object result = expr.evaluate(doc, XPathConstants.NODESET);
			        NodeList nodes = (NodeList) result;
			        nodes = (NodeList) result;
			        for (int i = 0; i < nodes.getLength(); i++) {
			            System.out.println("autor");
			        	System.out.println(nodes.item(i).
			        			getChildNodes().
			        			item(17).
			        			getChildNodes().
			        			item(5).
			        			getChildNodes().
			        			item(3).
			        			getTextContent());
			            System.out.println("title");		        	
			        	System.out.println(nodes.item(i).
			        			getChildNodes().item(17).
			        			getChildNodes().item(3).
			        			getTextContent());
			            System.out.println("rating");
			        	System.out.println(nodes.item(i)
                                .getChildNodes()
                                .item(15)                //node <title> is on first index
                                .getTextContent());
			        
			        	
			        }
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
	 
	        //Create XPath
	 
	       

	}

}
