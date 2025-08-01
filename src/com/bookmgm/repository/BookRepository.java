package com.bookmgm.repository;

import java.util.List;

import com.bookmgm.model.Book;

public interface BookRepository {
	boolean insert(Book book);
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remove(String id);
	void remove(Book book);	//오버로딩 가능
	int getCount();
}