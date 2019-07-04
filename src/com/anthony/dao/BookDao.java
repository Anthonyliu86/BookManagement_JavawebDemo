package com.anthony.dao;

import java.sql.SQLException;
import java.util.List;

import com.anthony.domain.Book;

public interface BookDao {
	
	/**
	 * 查询所有书
	 * @return 
	 * @throws SQLException 
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * 添加图书
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException;
	
	/**
	 * 根据id查询图书
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookById(String id) throws SQLException;
	
	public void updateBook(Book book) throws SQLException;
	
	/**
	 * 根据id删除图书
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public void delBook(String id) throws SQLException;

	public void delAllBook(String[] ids) throws SQLException;

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException;
	
	/**
	 * 得到总记录数
	 * @return
	 * @throws SQLException
	 */
	public int count() throws SQLException;
	
	/**
	 * 查找分页数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findBooks(int currentPage, int pageSize)throws SQLException;

}
