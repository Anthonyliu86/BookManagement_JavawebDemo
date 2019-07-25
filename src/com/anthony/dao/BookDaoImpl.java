package com.anthony.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.anthony.datasource.C3P0Utils;
import com.anthony.domain.Book;

public class BookDaoImpl implements BookDao {

	public List<Book> findAllBooks() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		List<Book> query = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		return query;
	}

	public void addBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)", book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription());
	}

	public Book findBookById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		Book book = qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
		return book;
	}

	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update book set name=?, price=?, pnum=?, category=?, description=? where id=?",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
	}

	public void delBook(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("delete from book where id=?", id);
	}

	public void delAllBook(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] {ids[i]};
		}
		qr.batch("delete from book where id=?", params);
	}

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		
		if(!"".equals(id.trim())) {
			sql += " and id like ?"; //因为id是随机UUID，不好记住，所以这里模糊匹配
			list.add("%"+id.trim()+"%"); // %abc% 这个是like的语法，这里需要拼接上这个%
		}
		if(!"".equals(category.trim())) {
			sql += " and category=?";
			list.add(category.trim());
		}
		if(!"".equals(name.trim())) {
			sql += " and name like ?";
			list.add("%"+name.trim()+"%");
		}
		if(!"".equals(minprice.trim())) {
			sql += " and price >?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice.trim())) {
			sql += " and price <?";
			list.add(maxprice.trim());
		}
		
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
	
	
	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		long l = (Long)qr.query("select count(*) from book", new ScalarHandler(1));
		return (int)l;
	}

	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),(currentPage-1)*pageSize, pageSize);
	}
	
	public List<Object> searchBookByName(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select name from book where name like ?", new ColumnListHandler<Object>(), "%" +name+"%");
	}

}
