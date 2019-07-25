package com.anthony.service;

import java.util.List;

import com.anthony.domain.Book;
import com.anthony.domain.PageBean;

public interface BookService {
	
	public List<Book> findAllBooks();
	
	public void addBook(Book book);
	
	public Book findBookById(String id);
	
	public void updateBook(Book book);
	
	public void delBook(String id);

	public void delAllBook(String[] ids);

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice);
	
	public PageBean findBooksPage(int currentPage, int pageSize);
	
	public List<Object> searchBookByName(String name);
}
