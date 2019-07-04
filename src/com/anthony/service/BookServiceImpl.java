package com.anthony.service;

import java.sql.SQLException;
import java.util.List;

import com.anthony.dao.BookDao;
import com.anthony.dao.BookDaoImpl;
import com.anthony.domain.Book;
import com.anthony.domain.PageBean;

public class BookServiceImpl implements BookService {
	
	//创建一个Dao对象
	BookDao bd = new BookDaoImpl();
	
	public List<Book> findAllBooks() {
		try {
			return bd.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addBook(Book book) {
		try {
			bd.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book findBookById(String id) {
		try {
			return bd.findBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book) {
		try {
			bd.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delBook(String id) {
		try {
			bd.delBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void delAllBook(String[] ids) {
		try {
			bd.delAllBook(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
		try {
			return bd.searchBooks(id,category,name,minprice,maxprice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PageBean findBooksPage(int currentPage, int pageSize) {
		try {
			int count = bd.count();
			int totalPage = (int)Math.ceil(count*1.0/pageSize);
			List<Book> books = bd.findBooks(currentPage, pageSize);
			//封装成一个PageBean对象
			PageBean pb = new PageBean();
			pb.setBooks(books);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setTotalPage(totalPage);
			pb.setPageSize(pageSize);
			return pb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
