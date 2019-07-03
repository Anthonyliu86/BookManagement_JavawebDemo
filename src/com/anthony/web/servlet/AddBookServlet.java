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
import com.anthony.utils.UUIDUtil;


public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取用户表单数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//调用业务逻辑
		BookService bs = new BookServiceImpl();
		bs.addBook(book);
		//分发转向
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
