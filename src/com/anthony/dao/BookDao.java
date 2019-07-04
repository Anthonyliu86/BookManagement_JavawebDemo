package com.anthony.dao;

import java.sql.SQLException;
import java.util.List;

import com.anthony.domain.Book;

public interface BookDao {
	
	/**
	 * ��ѯ������
	 * @return 
	 * @throws SQLException 
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * ���ͼ��
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException;
	
	/**
	 * ����id��ѯͼ��
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookById(String id) throws SQLException;
	
	public void updateBook(Book book) throws SQLException;
	
	/**
	 * ����idɾ��ͼ��
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public void delBook(String id) throws SQLException;

	public void delAllBook(String[] ids) throws SQLException;

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException;
	
	/**
	 * �õ��ܼ�¼��
	 * @return
	 * @throws SQLException
	 */
	public int count() throws SQLException;
	
	/**
	 * ���ҷ�ҳ����
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findBooks(int currentPage, int pageSize)throws SQLException;

}
