package com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LocationDAO;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocationDAO.retriveAvailableLocations();
		Map<Integer,String> map = LocationDAO.retriveAvailableLocations();
		for(Map.Entry<Integer,String>in:map.entrySet()){
	//		out.println(in.getKey()+" "+in.getValue());
			System.out.println(in.getKey()+" "+in.getValue());
		}
	for(Map.Entry<Integer,String> entry:LocationDAO.retriveAvailableLocations().entrySet())	{
		//out.println(String.format("<option value='%i'>%s</option>", entry.getKey(),entry.getValue()));
		
	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
