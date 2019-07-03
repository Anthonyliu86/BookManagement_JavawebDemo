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

public class SearchBooksServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单数据
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		
		//调用业务逻辑
		BookService bs = new BookServiceImpl();
		List<Book> list = bs.searchBooks(id,category,name,minprice,maxprice);
		//处理分发转向
		request.setAttribute("books", list);
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
