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
		//����idȥ����book
		BookService bs = new BookServiceImpl();
		Book book = bs.findBookById(id);
		
		//��session�й��ﳵȡ����
		HttpSession session = request.getSession();
		Map<Book, String> cart = (Map<Book, String>) session.getAttribute("cart");
		int num = 1;
		
		if(cart == null) {
			cart = new HashMap<Book, String>();
		}
		
		// ������ﳵ�а����Ȿ�飬num��Ҫ��1
		if(cart.containsKey(book)) {
			num = Integer.parseInt(cart.get(book)) + 1;
		}
		
		// ��ͼ����빺�ﳵ
		cart.put(book, num+"");
		
		// ��cart����Ż�session��������
		session.setAttribute("cart", cart);
		
		out.print("<a href='"+request.getContextPath()+"/pageServlet'>��������</a>�� <a href='"+request.getContextPath()+"/cart.jsp'>�鿴���ﳵ</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
