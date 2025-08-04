package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.BookMarketBooks;

public interface BookMarketRepository {
	
	int insert(BookMarketBooks entity);
	int getCount();
	List<BookMarketBooks> findAll();
	BookMarketBooks find(String id);
	int update(BookMarketBooks entity);
	int remove(String id);
}
