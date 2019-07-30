package com.anthony.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anthony.domain.Book;
import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;

public class AddCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		//根据id去查找book
		BookService bs = new BookServiceImpl();
		Book book = bs.findBookById(id);
		
		//从session中购物车取出来
		HttpSession session = request.getSession();
		Map<Book, String> cart = (Map<Book, String>) session.getAttribute("cart");
		int num = 1;
		
		if(cart == null) {
			cart = new HashMap<Book, String>();
		}
		
		// 如果购物车中包含这本书，num就要加1
		if(cart.containsKey(book)) {
			num = Integer.parseInt(cart.get(book)) + 1;
		}
		
		// 把图书放入购物车
		cart.put(book, num+"");
		
		// 把cart对象放回session作用域中
		session.setAttribute("cart", cart);
		
		out.print("<a href='"+request.getContextPath()+"/pageServlet'>继续购物</a>， <a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
