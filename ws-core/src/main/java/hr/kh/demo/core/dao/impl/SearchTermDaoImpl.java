package hr.kh.demo.core.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import hr.kh.demo.core.dao.SearchTermDao;
import hr.kh.demo.core.model.SearchTerm;
import hr.kh.demo.core.model.enums.SearchPlatform;

@Repository
public class SearchTermDaoImpl extends GenericDaoImpl<SearchTerm, Long> implements SearchTermDao {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public SearchTermDaoImpl() {
		super(SearchTerm.class);
	}
	
	public SearchTerm getLastValidSearchTerm(String term, SearchPlatform platform) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime validInterval = now.minusDays(7);
		
		String sqlQuery = "SELECT a FROM SearchTerm a"
				+ " WHERE a.term = :term"
				+ " AND a.searchDate >= :date"
				+ " AND a.platform = :platform";
		
		Query query = em.createQuery(sqlQuery, SearchTerm.class);
		query.setParameter("term", term);
		query.setParameter("date", Timestamp.valueOf(validInterval));
		query.setParameter("platform", platform);
		
		try {
			return (SearchTerm)query.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
