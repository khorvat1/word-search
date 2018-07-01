package hr.kh.demo.core.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hr.kh.demo.core.dao.SearchTermDao;
import hr.kh.demo.core.model.SearchTerm;

@Repository
public class SearchTermDaoImpl extends GenericDaoImpl<SearchTerm, Long> implements SearchTermDao {
	
	public SearchTermDaoImpl() {
		super(SearchTerm.class);
	}
	
	public SearchTerm getLastValidSearchTerm(String term) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime validInterval = now.minusDays(7);
		
		String sqlQuery = "SELECT a FROM SearchTerm a"
				+ " WHERE a.term = :term"
				+ " AND a.searchDate >= :date";
		
		Query query = em.createQuery(sqlQuery, SearchTerm.class);
		query.setParameter("term", term);
		query.setParameter("date", Timestamp.valueOf(validInterval));
		
		try {
			return (SearchTerm)query.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			//TODO logger
			return null;
		}
	}

}
