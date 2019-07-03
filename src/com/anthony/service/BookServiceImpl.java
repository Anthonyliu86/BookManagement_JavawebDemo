package com.anthony.service;

import java.sql.SQLException;
import java.util.List;

import com.anthony.dao.BookDao;
import com.anthony.dao.BookDaoImpl;
import com.anthony.domain.Book;

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

}
