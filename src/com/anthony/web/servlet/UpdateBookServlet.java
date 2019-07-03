package com.anthony.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.anthony.domain.Book;
import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;


public class UpdateBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Book book = new Book();
		
		try {
			BeanUtils.populate(book, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		BookService bs = new BookServiceImpl();
		bs.updateBook(book);
		
		//Ìø×ª
		request.getRequestDispatcher("/bookListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
