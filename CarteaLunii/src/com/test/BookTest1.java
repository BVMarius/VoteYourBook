package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.model.Book;

public class BookTest1 {

	Book b;
	Book b1;
	Book b2;
	
	@Before
	public void setup(){
		System.out.println("Hello");
		b  = new Book();
		List<Book> books = new ArrayList<>();
		b.setAuthor("Noe Armin");
		b.setTitle("La capatul lumii");
		b1  = new Book();
		b1.setAuthor("Ion Arion");
		b1.setTitle("Despre ceaiuri");
		b2  = new Book();
		b2.setAuthor("Donald Trump");
		b2.setTitle("Eu sunt");
		books.add(b);
		books.add(b1);
		books.add(b2);
	}
	
	@Test
	public void testInit() {
		//fail("Not yet implemented");
		assertNotNull(b);
	}
	
	public void listBooks(){
		
		
	}
	
	


}
