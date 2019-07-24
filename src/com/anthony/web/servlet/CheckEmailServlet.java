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
		//1. 拿到参数
		String email = request.getParameter("email");
		// 根据email去查找用户
		UserService us = new UserServiceImpl();
		User user = us.findUserByEmail(email);
		
		PrintWriter out = response.getWriter();
		//判断邮箱是否存在
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
