package member;

import java.util.List;

public interface GenericInterface<T> {

	public List<T> search(String name);
	public T search(int id);	//오버로딩
	public int delete(int id);
	public int update(T entity);
	public List<T> listAll();
	public int insert(T entity);
}
