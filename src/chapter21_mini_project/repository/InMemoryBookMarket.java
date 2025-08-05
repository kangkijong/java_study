package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookMarketBooks;
import db.DBConn;
import db.GenericRepositoryInterface;

public class InMemoryBookMarket extends DBConn 
				implements GenericRepositoryInterface<BookMarketBooks> {
	
	public InMemoryBookMarket() {}

	@Override
	public int insert(BookMarketBooks entity) {
		return 0;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public List<BookMarketBooks> findAll() {
		List<BookMarketBooks> list = null;
		String sql = "SELECT bid, title, price, author, intro, category, left(bdate, 10) "
				+ "FROM book_market_books ";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<BookMarketBooks>();
				while(rs.next()) {
					BookMarketBooks book = new BookMarketBooks();
					book.setBid(rs.getString(1));
					book.setTitle(rs.getString(2));
					book.setPrice(rs.getInt(3));
					book.setAuthor(rs.getString(4));
					book.setIntro(rs.getString(5));
					book.setCategory(rs.getString(6));
					book.setBdate(rs.getString(7));
					list.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookMarketBooks find(String id) {	// ✔
		BookMarketBooks book = null;
	    String sql = "SELECT bid, title, price, author, intro, category, bdate "
	    			 + " FROM book_market_books WHERE bid = ? ";
	    
	    try {
	        getPreparedStatement(sql);
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            book = new BookMarketBooks();
	            book.setBid(rs.getString(1));
	            book.setTitle(rs.getString(2));
	            book.setPrice(rs.getInt(3));
	            book.setAuthor(rs.getString(4));
	            book.setIntro(rs.getString(5));
	            book.setCategory(rs.getString(6));
	            book.setBdate(rs.getString(7));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return book;
	}

	@Override
	public int update(BookMarketBooks entity) {
		return 0;
	}

	@Override
	public int remove(String id) {
		return 0;
	}
	
	
}
