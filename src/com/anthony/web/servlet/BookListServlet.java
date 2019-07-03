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
		//����ҵ���߼�
		BookService bs = new BookServiceImpl();
		List<Book> books = bs.findAllBooks();
		//��תҳ��
		if(books != null) {
			request.setAttribute("books", books); //��books���list���Ϸ���request������
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
