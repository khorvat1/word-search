package hr.kh.demo.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import hr.kh.demo.core.dao.GenericDao;

public abstract class GenericDaoImpl <T, PK extends Serializable> implements GenericDao<T, PK> {
	
	@PersistenceContext
	protected EntityManager em;
	
    private final Class<T> type;
    
    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }
    
    @Transactional
    public T create(T o) {
    	em.persist(o);
        return o;
    }
 
    public T getById(PK id) {
        return em.find(type, id);
    }
 
    @Transactional
    public T update(T o) {
        return em.merge(o);
    }
 
    @Transactional
    public void delete(T o) {
        em.remove(o);
    }
    
    public List<T> getAll(){
    	String query = "SELECT a FROM " + type.getName() + " a";
    	return em.createQuery(query, type).getResultList();
    }

}
