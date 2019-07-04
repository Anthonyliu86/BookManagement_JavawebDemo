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
		//初始化每页显示记录数
		int pageSize = 4;
		int currentPage = 1; //表示当前页
		String currPage = request.getParameter("currentPage");
		if(currPage != null) { //第一次访问页面currPage可能为null
			currentPage = Integer.parseInt(currPage);
		}
		
		//调用业务层方法
		BookService bs = new BookServiceImpl();
		//分页查询，并返回PageBean对象
		PageBean pb = bs.findBooksPage(currentPage, pageSize);
		
		//请求跳转
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
