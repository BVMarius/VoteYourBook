package com.business;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.model.Book;

public class Result {
	
	public static List<Book> parseGoodReadsResult(String input){
		 final Charset UTF_8 = Charset.forName("UTF-8");

		  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true); 
	        DocumentBuilder builder;
	        ArrayList<Book> books =  new ArrayList<Book>();
			try {
				builder = factory.newDocumentBuilder();
				 String stringToBeParsed = input;
	
				Document doc = builder.parse(new InputSource(new StringReader(stringToBeParsed)));
				 XPathFactory xpathfactory = XPathFactory.newInstance();
			        XPath xpath = xpathfactory.newXPath();
			        XPathExpression expr = xpath.compile("//work");
			    	
		        Object result = expr.evaluate(doc, XPathConstants.NODESET);
			        NodeList nodes = (NodeList) result;
			        nodes = (NodeList) result;
			        for (int i = 0; i < nodes.getLength(); i++) {
			        	Book b = new Book();
			            b.setAuthor(new String(nodes.item(i).
			        			getChildNodes().
			        			item(17).
			        			getChildNodes().
			        			item(5).
			        			getChildNodes().
			        			item(3).
			        			getTextContent().getBytes(),UTF_8));
			            b.setTitle(new String(nodes.item(i).
			        			getChildNodes().item(17).
			        			getChildNodes().item(3).
			        			getTextContent().getBytes(),UTF_8));
			            b.setRating(Double.valueOf(nodes.item(i)
	                              .getChildNodes()
	                              .item(15)                
	                              .getTextContent()));

			        books.add(b);
			    
			        }
			} catch (ParserConfigurationException e) {

				e.printStackTrace();
			} catch (XPathExpressionException e) {

				e.printStackTrace();
			}
			catch(SAXException ex){
				ex.printStackTrace();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
			return books;       
	}
	
	
	static URL url = null;
	static String inline = "";

	public static String queryQoodReadsAPI(String search) {

		   StringBuilder sb = new StringBuilder();
			 
		
		try {
			Properties props = new Result().loadProperties();
			String host = props.getProperty("host");
			String entity = props.getProperty("entity");
			String query = props.getProperty("query");
			System.out.println(host+entity+"&"+query+search);
			url = new URL(host+entity+"&"+query+search);
			HttpURLConnection connURL = ((HttpURLConnection) url.openConnection());
			connURL.setRequestMethod("GET");
	
			connURL.connect();

			int responseCode = connURL.getResponseCode();
				if(responseCode!=200){
					
				throw new RuntimeException("Invalid response"+responseCode);
				}
				else{
					
				System.out.println(responseCode);

			}
				InputStream is = connURL.getInputStream();
		        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
		     
		   
		            while ((inline = bf_reader.readLine()) != null) {
		                sb.append(inline).append("\n");
		            }

		        }
			
		catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString(); 

	}
	
	public Properties loadProperties(){
		
		Properties props = new Properties();
		InputStream is = getClass().getResourceAsStream("/com/base/deploy.properties");
		 try {
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return props;
	}
	
	public static void main(String...strings) {
		
		List<Book> list = parseGoodReadsResult(queryQoodReadsAPI("hemingway"));
		for(Book b:list){
			System.out.println(b.getAuthor());
			System.out.println(b.getTitle());
			System.out.println(b.getRating());
		}
		
	}

}
