package com.anthony.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anthony.service.BookService;
import com.anthony.service.BookServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class SearchBookAJAXServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		
		BookService bs = new BookServiceImpl();
		List<Object> list = bs.searchBookByName(name);
		// 把集合中元素转换成字符串返回到网页，多个元素逗号隔开
//		String str = "";
//		for (int i = 0; i < list.size(); i++) {
//			if(i > 0) {
//				str += ",";
//			}
//			str += list.get(i);
//		}
		String str = JSONArray.fromObject(list).toString();
		System.out.println(str);
		// 把数据响应到客户端
		response.getWriter().write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

