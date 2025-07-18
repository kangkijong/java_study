package com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.Book;
import com.scoremgm.model.Member;

public class Yes24BookRepository implements BookRepository {
	
	List<Book> library = new ArrayList<Book>();
	
	public Yes24BookRepository() {
		System.out.println("** 예스24 도서관 생성 완료 **");
	}
	
	@Override
	public boolean insert(Book book) {
		if(book != null) {
			return library.add(book);
		} else {
			return false;
		}
	}
	
	@Override
	public List<Book> selectAll() {
		return library;
	}
	
	@Override
	public Book select(String id) {
		Book book = null;
		
		for(Book b : library) {
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	@Override
	public void update(Book book) {
		int idx = -1;
		int i = 0;
		
		for(Book b : library) {
			if(b.getId().equals(book.getId())) {
				idx = i;
				break;
			}
			i++;
		}
		library.set(idx, book);
		
	}
	
	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b.getId().equals(id)) {
				ie.remove();
				break;
			}
		}
	}
	
	@Override
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b == book) {
				ie.remove();
				break;
			}
		}
	}
	
	@Override
	public int getCount() {
		return library.size();
	}
}
