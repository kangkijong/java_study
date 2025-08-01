package db;

import java.util.List;

public interface GenericRepositoryInterface<T> {
	int insert(T entity);
	int getCount();
	List<T> findAll();
	T find(String id);
	int update(T entity);
	int remove(String id);
	void close();
}
