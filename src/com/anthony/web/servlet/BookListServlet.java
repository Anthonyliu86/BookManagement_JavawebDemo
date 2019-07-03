package com.anthony.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.domain.Book;
import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;


public class BookListServlet extends HttpServlet {
	  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//调用业务逻辑
		BookService bs = new BookServiceImpl();
		List<Book> books = bs.findAllBooks();
		//跳转页面
		if(books != null) {
			request.setAttribute("books", books); //把books这个list集合放入request对象中
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
