package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.xml.sax.SAXException;

import com.business.Result;
import com.model.Book;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/search_book.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String searchCriterion = request.getParameter("search");
		if(searchCriterion!=null){
			List<Book> books = Result.parseGoodReadsResult(Result.queryQoodReadsAPI(plusConcatenation(searchCriterion)));
			request.setAttribute("lista", books);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
			view.forward(request, response);
		}
		PrintWriter out = response.getWriter();
		out.print("Is null");
	}
	private static String plusConcatenation(String searchCriterion){

	String[] ar = searchCriterion.split("\\s+");
	StringBuilder sb = new StringBuilder("");
	
	for(int i=0; i<ar.length; i++){
		System.out.println(ar[i]);
		sb.append(ar[i]);
		if(i!=ar.length-1){
			sb.append("+");
		}
	}
	 return sb.toString();
	
	}
	
}
