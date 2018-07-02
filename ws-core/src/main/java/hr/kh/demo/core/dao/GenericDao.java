package hr.kh.demo.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {
	
	public T create(T newObject);
	
	public T getById(PK id);
	
	public T update(T transientObject);
	
	public void delete(T persistentObject);
	
	public List<T> getAll();
}
