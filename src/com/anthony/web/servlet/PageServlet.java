package com.anthony.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.domain.PageBean;
import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;


public class PageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ʼ��ÿҳ��ʾ��¼��
		int pageSize = 4;
		int currentPage = 1; //��ʾ��ǰҳ
		String currPage = request.getParameter("currentPage");
		if(currPage != null) { //��һ�η���ҳ��currPage����Ϊnull
			currentPage = Integer.parseInt(currPage);
		}
		
		//����ҵ��㷽��
		BookService bs = new BookServiceImpl();
		//��ҳ��ѯ��������PageBean����
		PageBean pb = bs.findBooksPage(currentPage, pageSize);
		
		//������ת
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
