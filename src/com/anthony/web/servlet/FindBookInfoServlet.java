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
		//�ȴ�����url�ϻ�ȡkeyΪid��ֵ��Ҳ����ͼ���id
		String id = request.getParameter("id");
		//����id��ѯ�Ȿ�飬�����Ȿ��
		BookService bs = new BookServiceImpl();
		Book  book = bs.findBookById(id);
		
		//������ת���Ȱ��Ȿ�����ó�request������
		request.setAttribute("book", book);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
