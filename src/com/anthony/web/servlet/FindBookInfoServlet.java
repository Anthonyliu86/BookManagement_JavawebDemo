package com.anthony.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.domain.Book;
import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;


public class FindBookInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//先从请求url上获取key为id的值，也就是图书的id
		String id = request.getParameter("id");
		//根据id查询这本书，返回这本书
		BookService bs = new BookServiceImpl();
		Book  book = bs.findBookById(id);
		
		//处理跳转，先把这本书设置成request的属性
		request.setAttribute("book", book);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
