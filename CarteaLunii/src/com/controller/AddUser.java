package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Type;
import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_user.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("it'here");
		performTask( request,  response);
		System.out.println("it'here");
	}
	
	private void performTask(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String town = req.getParameter("town");
			UserDAO.createUser(User.createInstance(firstName, lastName, password, email), Integer.valueOf(town), Type.NORMAL); 
			
			System.out.println(firstName + " "+ lastName + " "+ password+" "+ email+" "+town);
			
			
	}
		catch(Exception ex){
			System.out.println("error");
		}
	}

}
