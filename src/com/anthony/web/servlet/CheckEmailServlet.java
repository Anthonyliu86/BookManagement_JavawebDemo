package com.anthony.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.domain.User;
import com.anthony.service.UserService;
import com.anthony.service.UserServiceImpl;

public class CheckEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. �õ�����
		String email = request.getParameter("email");
		// ����emailȥ�����û�
		UserService us = new UserServiceImpl();
		User user = us.findUserByEmail(email);
		
		PrintWriter out = response.getWriter();
		//�ж������Ƿ����
		if ( user != null) {
			out.print("true");
		}else {
			out.print("false");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
