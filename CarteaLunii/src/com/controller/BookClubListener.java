package com.controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class BookClubListener
 *
 */
@WebListener
public class BookClubListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BookClubListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext servletContext = sce.getServletContext();
    	ArrayList<String> books = (ArrayList<String>) servletContext.getAttribute("books");
    	
    	if(books==null) {
    		System.out.println("No passager list created yet");
    		books = new ArrayList<String>();
    		servletContext.setAttribute("books", books);
    	}
    	
    }
	
}
