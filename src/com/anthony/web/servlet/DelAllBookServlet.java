package com.anthony.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;

public class DelAllBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ������,�õ�����id
		String[] ids = request.getParameterValues("ids");
		
		//ʵ��ҵ���߼�
		BookService bs = new BookServiceImpl();
		bs.delAllBook(ids);
		//������ת
		request.getRequestDispatcher("/bookListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
